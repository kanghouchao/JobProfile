package com.kang.resume.user.auth.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class Email {
    private String value;

    private Email(final String value) {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.value = value.toLowerCase().trim();
    }

    /**
     * Creates an Email instance from a string value.
     *
     * @param value The email address string.
     * @return A new Email instance.
     * @throws IllegalArgumentException if the email format is invalid.
     */
    public static Email of(final String value) {
        return new Email(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
