package com.huawei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZipkinClientApplication {
	@Bean
	Sampler sampler() {
		return new AlwaysSampler();
	}

	// #region main

	public static void main(String[] args) {
		SpringApplication.run(ZipkinClientApplication.class, args);
	}

	// #endregion
}
