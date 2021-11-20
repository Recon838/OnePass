package com.raliev.onepass.service;

import com.raliev.onepass.utils.Expiration;
import com.raliev.onepass.repository.SecretRepository;
import com.raliev.onepass.entity.Secret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DBSecretService implements SecretService {

	@Autowired
	private SecretRepository repository;

	@Override
	public Long add(Secret secret) {
		return repository.save(secret).getId();
	}

	@Override
	public Optional<Secret> get(Long id) {
		Optional<Secret> secret = repository.findById(id);

		if (secret.isPresent()) {
			LocalDateTime expirationDate = secret.get().getExpirationDate();

			if (expirationDate == null) {
				delete(id);
				return secret;

			} else if (!Expiration.isExpired(expirationDate)) {
				return secret;
			}

			delete(id);
		}

		return Optional.empty();
	}

	@Override
	public void cleanExpiredTo(LocalDateTime date) {
		repository.deleteExpiredSecretsByDate(date);
	}

	private void delete(Long id) {
		repository.deleteById(id);
	}
}
