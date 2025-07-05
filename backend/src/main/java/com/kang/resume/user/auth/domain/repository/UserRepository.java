package com.kang.resume.user.auth.domain.repository;

import com.kang.resume.user.auth.domain.entity.User;
import com.kang.resume.user.auth.domain.vo.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by their email address.
     *
     * @param email The email address to search for.
     * @return An Optional containing the found user, or empty if not found.
     */
    Optional<User> findByEmail(Email email);
    /**
     * Finds a user by their email address and verification token.
     *
     * @param email The email address to search for.
     * @param token The verification token to search for.
     * @return An Optional containing the found user, or empty if not found.
     */
    Optional<User> findByEmailAndVerificationToken(Email email, String token);
}
