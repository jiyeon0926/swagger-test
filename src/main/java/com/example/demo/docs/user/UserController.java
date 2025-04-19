package com.example.demo.docs.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "user", description = "회원가입, 회원탈퇴, 사용자 전체 조회, 사용자 단 건 조회")
public class UserController {

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "회원가입 성공",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SignupResDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "이미 가입된 사용자",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"error\": {\n" +
                                            "    \"code\": \"USER_ALREADY_EXISTS\",\n" +
                                            "    \"message\": \"이미 가입된 사용자입니다.\"\n" +
                                            "  }\n" +
                                            "}"
                            )
                    )
            )
    })
    public ResponseEntity<SignupResDto> signup(@RequestBody SignupReqDto signupReqDto) {
        SignupResDto signupResDto = new SignupResDto();

        signupResDto.setEmail(signupReqDto.getEmail());
        signupResDto.setPassword(signupReqDto.getPassword());
        signupResDto.setName(signupReqDto.getName());

        return new ResponseEntity<>(signupResDto, HttpStatus.CREATED);
    }
}