package com.kang.resume.user.auth.domain.entity;

import com.kang.resume.user.auth.domain.vo.Email;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email"))
    private Email email;

    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private boolean emailVerified;

    private String verificationToken;

    private LocalDateTime tokenExpiryTime;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public static User createUnverifiedUser(Email email) {
        User user = new User();
        user.email = email;
        user.enabled = false;
        user.emailVerified = false;
        user.refreshVerificationToken();
        user.createdAt = LocalDateTime.now();
        return user;
    }

    public void refreshVerificationToken() {
        this.verificationToken = UUID.randomUUID().toString();
        this.tokenExpiryTime = LocalDateTime.now().plusHours(24);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email.getValue();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
