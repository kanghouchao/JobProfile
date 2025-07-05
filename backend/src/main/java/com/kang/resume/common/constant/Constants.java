package com.kang.resume.common.constant;

/**
 * Utility class for application-wide constants.
 */
public final class Constants {

    /**
     * Private constructor to prevent instantiation.
     */
    private Constants() {
        // Private constructor to prevent instantiation
    }

    /**
     * Maximum age for CORS preflight requests in seconds.
     */
    public static final int CORS_MAX_AGE_SECONDS = 3600;
    /**
     * Length of the "Bearer " prefix in JWT tokens.
     */
    public static final int BEARER_TOKEN_PREFIX_LENGTH = 7;
    /**
     * Expiry hours for verification tokens.
     */
    public static final int VERIFICATION_TOKEN_EXPIRY_HOURS = 24;
    /**
     * Code representing an unknown gender.
     */
    public static final int GENDER_UNKNOWN_CODE = 10;
    /**
     * Minimum length for user passwords.
     */
    public static final int MIN_PASSWORD_LENGTH = 8;
}
