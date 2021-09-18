package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication  // 스프링부트 자동설정
public class Application {  // 프로젝트의 메인클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
