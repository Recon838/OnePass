package com.raliev.onepass.config;

import com.raliev.onepass.entity.Secret;
import com.raliev.onepass.utils.Expiration;
import com.raliev.onepass.utils.LocalDateTimes;
import org.ehcache.expiry.ExpiryPolicy;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Supplier;

public class DefaultCacheExpiryPolicy implements ExpiryPolicy<String, Secret> {

	@Override
	public Duration getExpiryForCreation(String aString, Secret secret) {
		return Optional.ofNullable(secret.getExpirationDate())
				.map(expirationDate -> Duration.between(LocalDateTimes.currentDateTime(), expirationDate))
				.orElse(Expiration.DEFAULT_EXPIRY_DURATION);
	}

	@Override
	public Duration getExpiryForAccess(String aString, Supplier<? extends Secret> supplier) {
		return null;
	}

	@Override
	public Duration getExpiryForUpdate(String aString, Supplier<? extends Secret> supplier, Secret secret) {
		return null;
	}
}
