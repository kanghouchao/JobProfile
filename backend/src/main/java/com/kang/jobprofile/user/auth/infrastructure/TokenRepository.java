package com.kang.jobprofile.user.auth.infrastructure;

import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * @author kanghouchao
 */
@Repository
public interface TokenRepository extends JpaRepository<RegistrationToken, Long> {

    List<RegistrationToken> findByEmail(String email);

    Optional<RegistrationToken> findByToken(String token);

    void deleteByToken(String token);

    Optional<RegistrationToken> findByEmailAndToken(String email, String token);
}
