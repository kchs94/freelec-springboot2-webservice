package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 스프링부트 자동설정, 스프링 Bean 자동 읽기와 생성.
public class Application {  // 프로젝트의 메인클래스. 프로젝트 최상단에 위치한다.
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장  WAS 실행. 톰캣 필요 X
    }
}
