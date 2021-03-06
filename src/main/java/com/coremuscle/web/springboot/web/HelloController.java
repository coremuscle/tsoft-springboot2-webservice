package com.coremuscle.web.springboot.web;

import com.coremuscle.web.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
public class HelloController {

    @GetMapping("/hello")   // HTTP Method인 Get요청을 받을수있는 API로 만들어준다.
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        // @RequestParam 은 외부에서 API로 넘어온 파라미터를 가져오는 어노테이션이다.
        return new HelloResponseDto(name, amount);
    }

}