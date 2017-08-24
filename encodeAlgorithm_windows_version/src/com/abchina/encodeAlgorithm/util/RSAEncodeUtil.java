package com.abchina.encodeAlgorithm.util;

import java.security.MessageDigest;

import org.aspectj.weaver.ast.HasAnnotation;

public class RSAEncodeUtil {
	
	/**
	 * SHA-1 º”√‹∑Ω∑®
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encryptSHA(byte[] data) throws Exception {
		
		MessageDigest sha = MessageDigest.getInstance("SHA");
		sha.update(data);
		
		return RSAEncodeUtil.byte2hex(sha.digest());
	}
	
	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			}
			else {
				hs = hs + stmp;
			}
		}
		
		return hs.toUpperCase();
	}
	
//	public static void main(String[] args) throws Exception {
//		try {
//			String inputString = "201602";
//			
//			byte[] inputData = inputString.getBytes();
//			String outputData = RSAEncodeUtil.encryptSHA(inputData);
//			System.out.println(outputData);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
