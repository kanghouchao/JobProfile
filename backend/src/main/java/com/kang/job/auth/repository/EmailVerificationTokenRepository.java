package com.kang.job.auth.repository;

import com.kang.job.auth.entity.EmailVerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author kanghouchao
 */
@Repository
public interface EmailVerificationTokenRepository extends JpaRepository<EmailVerificationToken, Long> {

    EmailVerificationToken findByToken(String token);

    @Modifying
    @Query("UPDATE EmailVerificationToken e SET e.isUsed = true WHERE e.token = :token")
    void setToUsed(String token);
}
