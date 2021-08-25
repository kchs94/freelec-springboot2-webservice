package com.jojoldu.book.springboot.web;    // 컨트롤러와 관련된 클래스들을 담고있는 패키지.

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)    // Web에 집중할 수 있는 어노테이션
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

}
