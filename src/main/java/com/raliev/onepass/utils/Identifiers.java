package com.raliev.onepass.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Identifiers {

	private final static Base64.Encoder ENCODER = Base64.getUrlEncoder();
	private final static Base64.Decoder DECODER = Base64.getUrlDecoder();

	private Identifiers() {}

	// todo

	public static String encrypt(String id) {
		return new String(ENCODER.encode(id.getBytes()), StandardCharsets.UTF_8);
	}

	public static String decrypt(String encryptedId) {
		return new String(DECODER.decode(encryptedId), StandardCharsets.UTF_8);
	}

}
