package com.example.camtermembertest.mapper;

import com.example.camtermembertest.domain.Member;
import com.example.camtermembertest.domain.dto.request.JoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public Member toEntity(JoinRequestDto dto) {
        return Member.builder()
                .username(dto.getUsername())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build();
    }

    public JoinRequestDto toDto(Member entity) {
        return JoinRequestDto.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();

    }
}
