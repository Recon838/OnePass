package com.raliev.onepass.service;

import com.raliev.onepass.utils.Expiration;
import com.raliev.onepass.repository.SecretRepository;
import com.raliev.onepass.entity.Secret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class DBSecretService implements SecretService {

	@Autowired
	private SecretRepository repository;

	@Override
	public String add(Secret secret) {
		String uuid = UUID.randomUUID().toString();
		secret.setUuid(uuid);
		return repository.save(secret).getUuid();
	}

	@Override
	public Optional<Secret> get(String uuid) {
		Optional<Secret> secret = repository.findById(uuid);

		if (secret.isPresent()) {
			LocalDateTime expirationDate = secret.get().getExpirationDate();

			if (expirationDate == null) {
				delete(uuid);
				return secret;

			} else if (!Expiration.isExpired(expirationDate)) {
				return secret;
			}

			delete(uuid);
		}

		return Optional.empty();
	}

	@Override
	public void cleanExpiredTo(LocalDateTime date) {
		repository.deleteExpiredSecretsByDate(date);
	}

	private void delete(String uuid) {
		repository.deleteById(uuid);
	}
}
