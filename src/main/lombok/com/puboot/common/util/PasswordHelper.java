// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.common.util;

import com.puboot.module.admin.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码加密工具类
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
public final class PasswordHelper {
    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = new SecureRandomNumberGenerator();
    private static final String ALGORITHM_NAME = "md5";
    private static final int HASH_ITERATIONS = 2;

    public static void encryptPassword(User user) {
        user.setSalt(RANDOM_NUMBER_GENERATOR.nextBytes().toHex());
        String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), HASH_ITERATIONS).toHex();
        user.setPassword(newPassword);
    }

    public static String getPassword(User user) {
        return new SimpleHash(ALGORITHM_NAME, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), HASH_ITERATIONS).toHex();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        encryptPassword(user);
        System.out.println(user);
    }

    @java.lang.SuppressWarnings("all")
    private PasswordHelper() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
