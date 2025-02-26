package com.kang.jobprofile.user.auth.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * @author kanghouchao
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails getUserByEmail(String email);

}
