package com.kang.resume.domain.model.entity;

import lombok.Getter;

/**
 * @author kanghouchao
 */
@Getter
public enum Gender {

    /**
     * Represents male gender with code 0.
     */
    MAN(0, "男"),
    /**
     * Represents female gender with code 1.
     */
    WOMAN(1, "女"),
    /**
     * Represents unknown gender with code 10.
     */
    UNKNOWN(10, "未知");

    /**
     * The integer code representing the gender.
     */
    private final int code;
    /**
     * The description of the gender.
     */
    private final String desc;

    Gender(final int genderCode, final String genderDesc) {
        this.code = genderCode;
        this.desc = genderDesc;
    }

    /**
     * Returns the Gender enum based on the provided code.
     *
     * @param code The integer code of the gender.
     * @return The corresponding Gender enum.
     */
    public static Gender fromCode(final int code) {
        return switch (code) {
            case 0 -> MAN;
            case 1 -> WOMAN;
            default -> UNKNOWN;
        };
    }
}
