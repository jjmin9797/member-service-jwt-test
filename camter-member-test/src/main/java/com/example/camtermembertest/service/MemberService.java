package com.example.camtermembertest.service;

import com.example.camtermembertest.domain.Member;
import com.example.camtermembertest.domain.dto.request.JoinRequestDto;
import com.example.camtermembertest.mapper.MemberMapper;
import com.example.camtermembertest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    @Transactional
    public Long join(JoinRequestDto dto) {
        Member member = memberRepository.save(memberMapper.toEntity(dto));
        return member.getId();
    }
}
