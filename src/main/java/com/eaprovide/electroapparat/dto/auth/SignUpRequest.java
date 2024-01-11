package com.eaprovide.electroapparat.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignUpRequest {
    private String username;
    private String email;
    private String password;
}
