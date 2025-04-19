package com.kang.resume.user.auth.domain.repository;

import com.kang.resume.user.auth.domain.entity.User;
import com.kang.resume.user.auth.domain.vo.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(Email email);
    Optional<User> findByEmailAndVerificationToken(Email email, String token);
}
