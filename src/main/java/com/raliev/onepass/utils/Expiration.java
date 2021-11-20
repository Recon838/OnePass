package com.raliev.onepass.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Expiration {

	public static final Duration DEFAULT_EXPIRY_DURATION = Duration.ofMinutes(5);

	public static boolean isExpired(LocalDateTime time) {
		return LocalDateTimes.currentDateTime().isAfter(time);
	}

	public static LocalDateTime calcExpirationDateTime(LocalTime lifeTime) {
		LocalDateTime currentDateTime = LocalDateTimes.currentDateTime();

		if (lifeTime != null) {
			return currentDateTime
					.plusHours(lifeTime.getHour())
					.plusMinutes(lifeTime.getMinute())
					.plusSeconds(lifeTime.getSecond());
		}

		return currentDateTime
				.plusNanos(Expiration.DEFAULT_EXPIRY_DURATION.toNanos());
	}
}
