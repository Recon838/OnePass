package com.raliev.onepass.service;

import com.raliev.onepass.entity.Secret;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SecretService {

	String add(Secret secret);

	Optional<Secret> get(String uuid);

	void cleanExpiredTo(LocalDateTime date);
}
