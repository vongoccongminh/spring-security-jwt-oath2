package com.minh.springsecurityjwt.controller;

import com.minh.springsecurityjwt.jwt.JwtTokenProvider;
import com.minh.springsecurityjwt.presentation.request.LoginRequest;
import com.minh.springsecurityjwt.presentation.response.LoginResponse;
import com.minh.springsecurityjwt.presentation.response.RandomStuff;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authenticate")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping()
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest request, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            throw new Exception("abc");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

}
