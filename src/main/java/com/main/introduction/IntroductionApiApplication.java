package com.main.introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;


@EnableEurekaServer
@EnableJpaAuditing // Auditing 기능 사용을 위해서는 Run Application Class에 해당 어노테이션 추가 
@SpringBootApplication
public class IntroductionApiApplication {

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(IntroductionApiApplication.class, args);
	}

}
