package com.jojoldu.book.springboot.web;    // 컨트롤러와 관련된 클래스들을 담고있는 패키지.

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
* @Runwith
* 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.
* 여기서는 SpringRunner라는 스프링 실행자를 사용합니다.
* 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 합니다.
*
* @WebMvcTest
* 여러 스프링 테스트 어노테이션 중, Web(spring MVC)에 집중할 수 있는 어노테이션입니다.
* 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있습니다.
* 단, @Service, @Component, @Repository 등은 사용할 수 없습니다.
* 여기서는 컨트롤러만 사용하기 때문에 선언합니다.
* */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired  // 스프링이 관리하는 빈을 주입 받음
    private MockMvc mvc;    // 이 클래스를 통해 GET, POST 등에 대한 API 테스트를 할 수 있음.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함
                .andExpect(status().isOk())    //HTTP Hedaer의 Status를 검증합니다.
                .andExpect(content().string(hello));    // Controller에서 "hello"를 리턴하기에 이 값이 맞는지 검증합니다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)    // param: 1.API 테스트할 때 사용될 요청 파라미터를 설정합니다
                        .param("amount", String.valueOf(amount))) // 2. 단 값은 String만 허용 3. 숫자/날짜 데이터도 등록할 때 문자열로 변경해야 등록가능
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // jsonPath: 1. JSON 응답값을 필드별로 검증할수있는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));// 2. $을 기준으로 필드명을 명시합니다. 3. 여기서는 name와 amoumt을 검증하니 $.name, $.ammount로 검증합니다.
    }
}
