import os
import re
import subprocess
import xml.etree.ElementTree as ET
import sys


def delbankline(file):
    with open(file, 'r') as f:
        lines = [x for x in f.readlines() if not re.search(r'^\s+$', x)]
    with open(file, 'w') as fw:
        fw.writelines(lines)


def delombok(file):
    with open(file, 'r+') as f:
        lines = f.readlines()
        f.seek(0)
        f.truncate()
        for line in lines:
            # f.write(line.replace('src/main/java', 'src/main/lombok'))
            line = line.replace("<directory>${project.basedir}/src/main</directory>",
                                "<directory>${project.basedir}/src/main/lombok</directory>")
            line = line.replace('src/main/java', 'src/main/lombok')
            f.write(line)

    tree = ET.ElementTree()
    # 去掉ns0标签
    XML_NS_NAME = ""
    XML_NS_VALUE = "http://maven.apache.org/POM/4.0.0"
    ET.register_namespace(XML_NS_NAME, XML_NS_VALUE)
    tree.parse(file)
    root = tree.getroot()
    pre = (re.split('project', root.tag))[0]
    # 生成元素
    sourceDirectory = ET.Element("sourceDirectory")
    goal = ET.Element("goal")
    phase = ET.Element("phase")
    groupId = ET.Element("groupId")
    artifactId = ET.Element("artifactId")
    version = ET.Element("version")
    # 赋值
    #sourceDirectory.text = "${project.basedir}/src/main/lombok"
    sourceDirectory.text = "src/main/lombok"
    goal.text = "delombok"
    phase.text = "generate-sources"
    groupId.text = "org.projectlombok"
    artifactId.text = "lombok-maven-plugin"
    version.text = "1.18.4.0"
    # 打包
    goals = ET.Element("goals")
    goals.append(goal)
    addOutputDirectory = ET.Element("addOutputDirectory")
    addOutputDirectory.text = "false"
    sourceDirectory2 = ET.Element("sourceDirectory")
    sourceDirectory2.text = "src/main/java"
    outputDirectory = ET.Element("outputDirectory")
    #outputDirectory.text = "${project.basedir}/src/main/lombok"
    outputDirectory.text = "src/main/lombok"
    encoding = ET.Element("encoding")
    encoding.text = "UTF-8"
    configuration = ET.Element("configuration")
    configuration.append(encoding)
    configuration.append(addOutputDirectory)
    configuration.append(sourceDirectory2)
    configuration.append(outputDirectory)
    execution = ET.Element("execution")
    execution.append(phase)
    execution.append(goals)
    execution.append(configuration)
    executions = ET.Element("executions")
    executions.append(execution)
    plugin = ET.Element("plugin")
    plugin.append(groupId)
    plugin.append(artifactId)
    plugin.append(version)
    plugin.append(executions)

    # 多条件判断
    build = root.find(pre + "build")
    if build is None:
        build = ET.Element("build")
        root.append(build)
    build.insert(0, sourceDirectory)
    plugins = build.find(pre + "plugins")
    if plugins is None:
        plugins = ET.Element("plugins")
        build.insert(0, plugins)
    plugins.insert(0, plugin)
    # 写入
    tree.write(file, encoding="utf-8", xml_declaration=True)


def relombok(file):
    #删除自带的Lombok插件
    tree = ET.ElementTree()
    # 去掉ns0标签
    XML_NS_NAME = ""
    XML_NS_VALUE = "http://maven.apache.org/POM/4.0.0"
    ET.register_namespace(XML_NS_NAME, XML_NS_VALUE)
    tree.parse(file)
    root = tree.getroot()
    pre = (re.split('project', root.tag))[0]
    build = root.find(pre + "build")
    if build is None:
        return
    plugins = build.find(pre + "plugins")
    if plugins is None or len(plugins) == 0:
        return
    for plugin in plugins:
        for child in plugin:
            if child.text == "lombok-maven-plugin":
                plugins.remove(plugin)
    # 写入
    tree.write(file, encoding="utf-8", xml_declaration=True)


if __name__ == "__main__":
    file = sys.argv[1]
    delbankline(file)
    relombok(file)
    delombok(file)
    print("finish!!")
