package com.kang.jobprofile.mail.infrastructure;

import com.kang.jobprofile.mail.model.RegistrationToken;
import org.springframework.stereotype.Repository;

/**
 * @author kanghouchao
 */
@Repository
public interface TokenRepository {

    RegistrationToken findByToken(String token);

    void save(RegistrationToken registrationToken);

}
