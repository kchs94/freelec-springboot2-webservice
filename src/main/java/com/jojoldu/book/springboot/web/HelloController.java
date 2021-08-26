package com.jojoldu.book.springboot.web;    // 컨트롤러와 관련된 클래스들을 담고있는 패키지.

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
* @RestController
* 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줍니다.
* 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 됩니다.
* */
@RestController
public class HelloController {

    @GetMapping("/hello")   // GET 요청을 만들수 있는 API를 만듬
    public String hello() {
        return "hello";
    }



    /*
    * @RequestPram
    * 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션입니다.
    * 여기서 외부에서 name(@RequestParam("name"))이란 이름으로 넘긴 파라미터를 파라미터를 메소드 파라미터 name(String name)에 저장하게 됩니다.
    * */
    @GetMapping("/hello/dto") // GET 요청을 만들 수 있는 API를 만듬
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
