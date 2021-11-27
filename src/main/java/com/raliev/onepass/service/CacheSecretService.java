package com.raliev.onepass.service;

import com.raliev.onepass.entity.Secret;
import org.ehcache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CacheSecretService implements SecretService {

	@Autowired
	private Cache<String, Secret> cache;

	@Override
	public String add(Secret secret) {
		String uuid = UUID.randomUUID().toString();
		secret.setUuid(uuid);
		cache.put(uuid, secret);
		return uuid;
	}

	@Override
	public Optional<Secret> get(String uuid) {
		return Optional.ofNullable(cache.get(uuid));
	}

	@Override
	public void cleanExpiredTo(LocalDateTime date) {
		// do nothing
	}
}
