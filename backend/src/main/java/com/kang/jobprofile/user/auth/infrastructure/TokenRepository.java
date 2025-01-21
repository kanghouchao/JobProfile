package com.kang.jobprofile.user.auth.infrastructure;

import com.kang.jobprofile.user.auth.domain.RegistrationToken;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author kanghouchao
 */
@Repository
public interface TokenRepository extends JpaRepository<RegistrationToken, Long> {

    @SQL("SELECT rt.* FROM registration_token rt WHERE rt.email =:email limit 1")
    RegistrationToken findByEmail(@Param("email") String email);

}
