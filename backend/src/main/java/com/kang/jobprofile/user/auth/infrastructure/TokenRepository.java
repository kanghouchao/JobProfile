package com.kang.jobprofile.user.auth.infrastructure;

import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import org.hibernate.annotations.processing.SQL;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * @author kanghouchao
 */
@Repository
public interface TokenRepository {

    @SQL("SELECT rt.* FROM registration_token rt WHERE rt.email = :email and rt.expiry_time > :now limit 1")
    RegistrationToken findByEmail(String email, LocalDateTime now);

    void save(RegistrationToken registrationToken);

}
