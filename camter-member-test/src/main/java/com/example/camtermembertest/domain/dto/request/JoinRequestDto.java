package com.example.camtermembertest.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoinRequestDto {

    private String username;
    private String password;
}
