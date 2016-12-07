package com.huawei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
// @EnableZipkinStreamServer
public class ZipkinSeverApplication {
	// #region main

	public static void main(String[] args) {
		SpringApplication.run(ZipkinSeverApplication.class, args);
	}

	// #endregion
}
