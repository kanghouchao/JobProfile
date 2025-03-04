package com.kang.jobprofile.user.auth.infrastructure;

import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


/**
 * @author kanghouchao
 */
@Repository
public interface TokenRepository extends JpaRepository<RegistrationToken, Long> {

    RegistrationToken findFirstByEmailAndExpiryTimeAfter(String email, LocalDateTime now);

}
