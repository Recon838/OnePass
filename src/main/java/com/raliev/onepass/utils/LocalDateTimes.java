package com.raliev.onepass.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class LocalDateTimes {

	private LocalDateTimes() {}

	public static LocalDateTime currentDateTime() {
		return LocalDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS);
	}

}
