package com.example.demo.docs.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "회원가입 응답 DTO")
public class SignupResDto {

    @Schema(description = "이메일", example = "user1@naver.com")
    private String email;

    @Schema(description = "이름", example = "홍길동")
    private String name;

    @Schema(description = "비밀번호", example = "User123@")
    private String password;
}
