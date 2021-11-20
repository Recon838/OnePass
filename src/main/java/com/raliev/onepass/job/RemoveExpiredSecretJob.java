package com.raliev.onepass.job;

import com.raliev.onepass.service.SecretService;
import com.raliev.onepass.utils.LocalDateTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class RemoveExpiredSecretJob {

	private static final Logger logger = LoggerFactory.getLogger(RemoveExpiredSecretJob.class);

	@Autowired
	private SecretService service;

	@Scheduled(fixedDelay = 60, timeUnit = TimeUnit.MINUTES)
	public void schedule() {
		LocalDateTime currentDateTime = LocalDateTimes.currentDateTime();

		service.cleanExpiredTo(currentDateTime);
		logger.info("Deleted for date: {}", currentDateTime);
	}
}
