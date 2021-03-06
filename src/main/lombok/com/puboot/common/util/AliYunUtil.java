// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.common.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.puboot.module.admin.vo.CloudStorageConfigVo;
import com.puboot.module.admin.vo.base.ResponseVo;
import java.io.ByteArrayInputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linzhaoguan
 * @date 2020/3/31 3:56 下午
 */
public final class AliYunUtil {
    @java.lang.SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AliYunUtil.class);

    public static ResponseVo<?> uploadFile(CloudStorageConfigVo cloudStorageConfig, String filePath, byte[] uploadBytes) {
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String endpoint = cloudStorageConfig.getAliyunEndPoint();
        String accessKeyId = cloudStorageConfig.getAliyunAccessKeyId();
        String accessKeySecret = cloudStorageConfig.getAliyunAccessKeySecret();
        String bucketName = cloudStorageConfig.getAliyunBucketName();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        try {
            ossClient.putObject(bucketName, filePath, new ByteArrayInputStream(uploadBytes));
        } catch (OSSException | ClientException e) {
            log.error("阿里云-上传文件发生异常", e);
            return ResultUtil.error(e.getMessage());
        }
        // 关闭OSSClient。
        ossClient.shutdown();
        return ResultUtil.success("上传成功");
    }

    @java.lang.SuppressWarnings("all")
    private AliYunUtil() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
