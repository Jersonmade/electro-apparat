package com.eaprovide.electroapparat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignUpRequest {
    private String username;
    private String email;
    private String password;
}
