package com.raliev.onepass.controller;

import com.raliev.onepass.dto.SecretDto;
import com.raliev.onepass.dto.SecretResponseDto;
import com.raliev.onepass.entity.Secret;
import com.raliev.onepass.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/secret")
public class SecretController {

	@Autowired
	private SecretService service;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Secret> get(@PathVariable("id") Long id) {
		Optional<Secret> secret = service.get(id);
		return secret
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SecretResponseDto add(@RequestBody SecretDto secretDto) {
		Long id = service.add(Secret.of(secretDto));
		return SecretResponseDto.of(id);
	}
}
