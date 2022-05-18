// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.common.util;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具类
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
public final class RegexUtils {
    /**
     * @param regex 正则表达式字符串
     * @param str   要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    public static List<String> match(String str, String regex) {
        if (null == str) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> list = new LinkedList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public static boolean checkByRegex(String str, String regex) {
        if (null == str) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    @java.lang.SuppressWarnings("all")
    private RegexUtils() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}