package com.forensic.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main ForensicApiApplication class
 * @author mamallan.chidambaram
 */
@SpringBootApplication
@EnableCaching
public class ForensicApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ForensicApiApplication.class, args);
	}
}
