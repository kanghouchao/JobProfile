package com.kang.resume.domain.model.entity;

import lombok.Getter;

/**
 * @author kanghouchao
 */
@Getter
public enum Gender {

    MAN(0, "男"), WOMAN(1, "女"), UNKNOWN(10, "未知");

    private final int code;
    private final String desc;

    Gender(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Gender fromCode(int code) {
        return switch (code) {
            case 0 -> MAN;
            case 1 -> WOMAN;
            default -> UNKNOWN;
        };
    }
}
