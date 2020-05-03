package com.minh.springsecurityjwt.presentation.response;

import lombok.Data;

@Data
public class LoginResponse {

    String accessToken;

    String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
