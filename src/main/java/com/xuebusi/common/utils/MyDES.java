package com.xuebusi.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * DES加密解密
 */
public class MyDES {
	/**
	 * DES算法密钥
	 */
	private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };

	/**
	 * 数据加密，算法（DES）
	 * 
	 * @param data
	 *            要进行加密的数据
	 * @return 加密后的数据
	 */
	@SuppressWarnings("restriction")
	public static String encryptBasedDes(String data) {
		String encryptedData = null;
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			// 加密对象
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			// 加密，并把字节数组编码成字符串
			encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
		} catch (Exception e) {
			// log.error("加密错误，错误信息：", e);
			throw new RuntimeException("加密错误，错误信息：", e);
		}
		return encryptedData;
	}

	/**
	 * 数据解密，算法（DES）
	 * 
	 * @param cryptData
	 *            加密数据
	 * @return 解密后的数据
	 */
	@SuppressWarnings("restriction")
	public static String decryptBasedDes(String cryptData) {
		String decryptedData = null;
		try {
			// DES算法要求有一个可信任的随机数源
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			// 解密对象
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
			// 把字符串解码为字节数组，并解密
			decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
		} catch (Exception e) {
			// log.error("解密错误，错误信息：", e);
			throw new RuntimeException("解密错误，错误信息：", e);
		}
		return decryptedData;
	}

	public static void main(String[] args) {
		String str = "123456haiqin";
		// DES数据加密
		String s1 = encryptBasedDes(str);
		System.out.println(s1);
		// DES数据解密
		String s2 = decryptBasedDes(s1);
		System.err.println(s2);
	}
}