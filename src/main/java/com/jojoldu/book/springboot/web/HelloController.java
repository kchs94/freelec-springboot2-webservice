package com.jojoldu.book.springboot.web;    // 컨트롤러와 관련된 클래스들을 담고있는 패키지.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌.
public class HelloController {

    @GetMapping("/hello")   // GET 요청을 만들수 있는 API를 만듬
    public String hello() {
        return "hello";
    }

}
