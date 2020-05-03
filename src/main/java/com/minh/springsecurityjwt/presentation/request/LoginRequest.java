package com.minh.springsecurityjwt.presentation.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank
    String username;

    @NotBlank
    String password;
}
