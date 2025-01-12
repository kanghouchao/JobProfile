package com.kang.jobprofile.user.auth.infrastructure;

import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import org.springframework.stereotype.Repository;

/**
 * @author kanghouchao
 */
@Repository
public interface TokenRepository {

    RegistrationToken findByToken(String token);

    void save(RegistrationToken registrationToken);

}
