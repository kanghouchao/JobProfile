package com.kang.jobprofile.user.auth.interfaces.rest;

import com.kang.jobprofile.user.auth.application.service.RegistrationService;
import com.kang.jobprofile.user.auth.interfaces.web.request.CompleteRegistrationRequest;
import com.kang.jobprofile.user.auth.interfaces.web.request.InitiateRegistrationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PutMapping("/initiate")
    public ResponseEntity<Void> initiateRegistration(
            @RequestBody @Valid InitiateRegistrationRequest request) {
        registrationService.initiateRegistration(request.email());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> completeRegistration(
            @RequestBody @Valid CompleteRegistrationRequest request) {
        registrationService.completeRegistration(
            request.email(),
            request.token(),
            request.password()
        );
        return ResponseEntity.ok().build();
    }
}
