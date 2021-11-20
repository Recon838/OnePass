package com.raliev.onepass.config;

import com.raliev.onepass.entity.Secret;
import com.raliev.onepass.service.CacheSecretService;
import com.raliev.onepass.service.SecretService;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.raliev.onepass")
public class ApplicationContext {

	@Bean
	public Cache cache() {
		CacheConfiguration<Long, Secret> config = CacheConfigurationBuilder
				.newCacheConfigurationBuilder(Long.class, Secret.class, ResourcePoolsBuilder.heap(10))
				.withExpiry(new DefaultCacheExpiryPolicy())
				.build();

		CacheManager manager = CacheManagerBuilder.newCacheManagerBuilder().build();
		manager.init();
		return manager.createCache("cache", config);
	}

	@Bean
	public SecretService service() {
		return new CacheSecretService();
//		return new DBSecretService();
	}
}
