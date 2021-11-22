package com.raliev.onepass.dto;

import com.raliev.onepass.entity.Secret;

import java.time.LocalDateTime;

public class SecretResponseDto {

	private String data;
	private LocalDateTime expirationDate;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public static SecretResponseDto of(Secret secret) {
		SecretResponseDto dto = new SecretResponseDto();
		dto.setData(secret.getData());
		dto.setExpirationDate(secret.getExpirationDate());
		return dto;
	}
}
