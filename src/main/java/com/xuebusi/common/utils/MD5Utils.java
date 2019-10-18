package com.xuebusi.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {

	public static final String MD5 = "MD5";//md5加密
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_ITERATIONS = 1024;//加密次数

	/**
	 * md5盐值加密
	 * @param username
	 * @param password
	 * @return
	 */
	public static String md5Salt(String username, String password) {
		ByteSource salt = ByteSource.Util.bytes(username);//用户名作为盐值
		SimpleHash simpleHash = new SimpleHash(MD5, password, salt, HASH_ITERATIONS);
		return simpleHash.toString();
	}

	/**
	 * 对字符串进行Md5加密
	 * 
	 * @param input 原文
	 * @return md5后的密文
	 */
	public static String md5(String input) {
		byte[] code = null;
        try {
            code = MessageDigest.getInstance("md5").digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            code = input.getBytes();
        }
        BigInteger bi = new BigInteger(code);
        return bi.abs().toString(32).toUpperCase();
	}
	
	/**
	 * 对字符串进行Md5加密
	 * 
	 * @param input 原文
	 * @param salt 随机数
	 * @return string
	 */
	public static String generatePasswordMD5(String input, String salt) {
		if(StringUtils.isEmpty(salt)) {
			salt = "";
		}
		return md5(salt + md5(input));
	}

	/**
	 * 加密测试
	 * @param args
	 */
	public static void main(String[] args) {
		//038bdaf98f2037b31f1e75b5b4c9b26e
		System.out.println(MD5Utils.md5Salt("admin", "123456"));
	}
	
}
