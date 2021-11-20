package com.raliev.onepass.service;

import com.raliev.onepass.entity.Secret;
import org.ehcache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CacheSecretService implements SecretService {

	private static final AtomicLong idCounter = new AtomicLong(0);

	@Autowired
	private Cache<Long, Secret> cache;

	@Override
	public Long add(Secret secret) {
		Long id = idCounter.getAndIncrement();
		secret.setId(id);
		cache.put(id, secret);
		return id;
	}

	@Override
	public Optional<Secret> get(Long id) {
		return Optional.ofNullable(cache.get(id));
	}

	@Override
	public void cleanExpiredTo(LocalDateTime date) {
		// do nothing
	}
}
