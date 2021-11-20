package com.raliev.onepass.dto;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class SecretResponseDto {

	private URI uri;

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public static SecretResponseDto of(Long secretId) {
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping()
				.path("secret/")
				.path(String.valueOf(secretId))
				.build()
				.toUri();

		SecretResponseDto dto = new SecretResponseDto();
		dto.setUri(uri);
		return dto;
	}
}
