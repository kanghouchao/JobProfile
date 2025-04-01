package com.kang.jobprofile.user.auth.application;

import com.kang.jobprofile.user.auth.application.dto.UserCreatorDTO;
import com.kang.jobprofile.user.auth.domain.RegistrationMailSendEvent;
import com.kang.jobprofile.user.auth.service.RegistrationTokenService;
import com.kang.jobprofile.user.auth.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;


/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationTokenService registrationTokenService;

    private final UserService userService;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void mailVerification(String email) {
        String token = this.registrationTokenService.save(email);
        this.applicationEventPublisher.publishEvent(
            new RegistrationMailSendEvent(email, token)
        );
    }

    @Transactional
    public void createUser(UserCreatorDTO userCreatorDTO) {
        this.registrationTokenService.checkToken(userCreatorDTO.email(), userCreatorDTO.token());
        this.userService.createUser(userCreatorDTO.email(), userCreatorDTO.password());
        this.registrationTokenService.deleteToken(userCreatorDTO.token());
    }
}
