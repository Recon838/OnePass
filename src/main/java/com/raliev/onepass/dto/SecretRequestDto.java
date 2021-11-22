package com.raliev.onepass.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public class SecretRequestDto {

	private String data;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime lifetime;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LocalTime getLifetime() {
		return lifetime;
	}

	public void setLifetime(LocalTime lifetime) {
		this.lifetime = lifetime;
	}
}
