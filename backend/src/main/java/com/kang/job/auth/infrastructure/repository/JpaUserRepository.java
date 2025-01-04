package com.kang.job.auth.infrastructure.repository;

import com.kang.job.auth.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kanghouchao
 */
@Repository
public interface JpaUserRepository extends JpaRepository<Account, Long> {

    /**
     * Get user by email
     *
     * @param email email
     * @return user entity
     */
    Account getUserByEmail(String email);

    /**
     * if user exists by email
     *
     * @param email email
     * @return bool
     */
    boolean existsByEmail(String email);
}
