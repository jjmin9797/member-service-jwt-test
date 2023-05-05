package com.example.camtermembertest.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoinResponseDto {

    private String message;
    private Long memberId;
    public JoinResponseDto(String message, Long memberId) {
        this.message = message;
        this.memberId = memberId;
    }
}
