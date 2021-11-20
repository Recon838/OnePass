package com.raliev.onepass.service;

import com.raliev.onepass.entity.Secret;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SecretService {

	Long add(Secret secret);

	Optional<Secret> get(Long id);

	void cleanExpiredTo(LocalDateTime date);
}
