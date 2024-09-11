package com.techworld83.ratelimitproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class RateLimitProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimitProducerApplication.class, args);
	}

	@Bean(name = "emailTaskExecutor")
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(20);
		executor.setThreadNamePrefix("TestThread-");
		executor.setKeepAliveSeconds(10);
		executor.initialize();
		return executor;
	}

}
