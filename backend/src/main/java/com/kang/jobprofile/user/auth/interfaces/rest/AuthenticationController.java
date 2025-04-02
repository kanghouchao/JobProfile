package com.kang.jobprofile.user.auth.interfaces.rest;

import com.kang.jobprofile.user.auth.application.service.AuthenticationService;
import com.kang.jobprofile.user.auth.interfaces.web.request.LoginRequest;
import com.kang.jobprofile.user.auth.interfaces.web.response.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        String token = authenticationService.authenticate(request.email(), request.password());
        return ResponseEntity.ok(LoginResponse.of(token));
    }
}
