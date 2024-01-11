package com.eaprovide.electroapparat.dto.auth;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
