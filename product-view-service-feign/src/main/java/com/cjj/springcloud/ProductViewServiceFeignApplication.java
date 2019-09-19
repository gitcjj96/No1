package com.cjj.springcloud;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@EnableFeignClients//表示用于使用 Feign 方式。
@EnableDiscoveryClient
@SpringBootApplication
public class ProductViewServiceFeignApplication {

	/**
	 * 在启动类里配置 Sampler 抽样策略： ALWAYS_SAMPLE 表示持续抽样
	 * @return
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductViewServiceFeignApplication.class, args);
	}

}
