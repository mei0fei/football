package com.example.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD5Util {
	
	static String md5(String password) {
		
		final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            	
            byte[] digest = md5MsgDigest.digest();
            String myHash = DatatypeConverter
              .printHexBinary(digest).toUpperCase();
            
            return myHash;
            
        } catch (final NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return null;
	}
	/*
	public static void main(String[] args) {
		
		String s = md5("abc");
		System.out.println(s);
	}
	*/
}
