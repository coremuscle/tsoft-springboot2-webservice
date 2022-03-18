package com.coremuscle.web.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든필드에 get 메소드를 생성해줌
@RequiredArgsConstructor    // 선언된 모든 final 필드에 생성자를 생성해줌
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
