package com.raliev.onepass.dto;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class LinkResponseDto {

	private URI uri;

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public static LinkResponseDto of(String uuid) {
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping()
				.path("secret/")
				.path(String.valueOf(uuid))
				.build()
				.toUri();

		LinkResponseDto dto = new LinkResponseDto();
		dto.setUri(uri);
		return dto;
	}
}
