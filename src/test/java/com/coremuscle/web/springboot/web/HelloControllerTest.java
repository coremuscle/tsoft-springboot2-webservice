package com.coremuscle.web.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

/**
 * HelloController가 "hello" 문자열을 정상적으로 반환하는지 테스트
 */
@RunWith(SpringRunner.class)    // 스프링부트테스트와 JUnit 연결자 역할
@WebMvcTest(controllers = HelloController.class)    // 여러 스플링 테스트 어노테이션중, Web(Spring MVC)에 집중할수있는 어노테이션?
public class HelloControllerTest {

    @Autowired  // 스프링이 관리하는 bean을 주입받는다?
    private MockMvc mvc;    // 웹 API 테스트할때 사용

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        // /hello 호출해서 정상처리여부와 응답값 검증
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        // /hello/dto 호출해서 정상처리여부와 응답값 검증
        // param() 은 요청파라미터 설정
        // jsonPath 는 JSON응답값을 필드별로 검증할수있다.
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
