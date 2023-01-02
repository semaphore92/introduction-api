package com.main.introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;


@EnableJpaAuditing
@SpringBootApplication
public class IntroductionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroductionApiApplication.class, args);
	}

}
