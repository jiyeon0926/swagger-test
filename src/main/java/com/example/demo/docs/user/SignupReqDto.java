package com.example.demo.docs.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "회원가입 요청 DTO")
public class SignupReqDto {

    @Schema(description = "이메일", example = "user1@naver.com")
    private String email;

    @Schema(description = "이름", example = "홍길동")
    private String name;

    @Schema(description = "비밀번호", example = "User123@")
    private String password;
}
