package com.example.camtermembertest.controller;

import com.example.camtermembertest.domain.dto.request.JoinRequestDto;
import com.example.camtermembertest.domain.dto.response.JoinResponseDto;
import com.example.camtermembertest.service.MemberService;
import com.example.camtermembertest.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final String JOIN_SUCCESS_MESSAGE = "가입 성공";
    private final String Login_SUCCESS_MESSAGE = "로그인 성공";
    private final JwtUtil jwtUtil;
    @GetMapping("/")
    public String home() {
        return "OK";
    }
    @PostMapping("/join")
    public ResponseEntity<JoinResponseDto> join(@RequestBody JoinRequestDto dto) {
        Long memberId = memberService.join(dto);
        return ResponseEntity.ok(new JoinResponseDto(JOIN_SUCCESS_MESSAGE, memberId));
    }

    @GetMapping("/token")
    public String getToken() {
        return jwtUtil.createToken(1L,"JM");
    }

    @PostMapping("/logins")
    public ResponseEntity<JoinResponseDto> login(@RequestHeader("Authorization") String token, @RequestBody JoinRequestDto dto) {
        String info = jwtUtil.validateToken(token);
        System.out.println("info = " + info);
        return ResponseEntity.ok(new JoinResponseDto(Login_SUCCESS_MESSAGE, 1L));
    }

}
