package com.kang.resume.user.auth.interfaces.rest;

import com.kang.resume.user.auth.application.service.RegistrationService;
import com.kang.resume.user.auth.interfaces.web.request.CompleteRegistrationRequest;
import com.kang.resume.user.auth.interfaces.web.request.InitiateRegistrationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * Completes the user registration process.
     *
     * @param request The request containing user registration completion details.
     * @return A ResponseEntity indicating the success of the operation.
     */
    @PostMapping("/complete")
    public ResponseEntity<Void> completeRegistration(
            @RequestBody @Valid final CompleteRegistrationRequest request) {
        registrationService.completeRegistration(request.email(), request.token(), request.password());
        return ResponseEntity.ok().build();
    }
}
