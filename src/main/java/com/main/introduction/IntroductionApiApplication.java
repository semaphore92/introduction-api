package com.main.introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableEurekaServer
@EnableJpaAuditing // Auditing 기능 사용을 위해서는 Run Application Class에 해당 어노테이션 추가 
@SpringBootApplication
public class IntroductionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroductionApiApplication.class, args);
	}

}
