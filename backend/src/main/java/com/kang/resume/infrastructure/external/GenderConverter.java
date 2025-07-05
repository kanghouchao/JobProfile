package com.kang.resume.infrastructure.external;

import com.kang.resume.domain.model.entity.Gender;
import jakarta.persistence.AttributeConverter;

import java.util.Objects;

import static com.kang.resume.common.constant.Constants.GENDER_UNKNOWN_CODE;

/**
 * @author kanghouchao
 */
public final class GenderConverter implements AttributeConverter<Gender, Integer> {

    /**
     * Converts a Gender enum to its corresponding database column representation (Integer).
     *
     * @param attribute The Gender enum to convert.
     * @return The integer representation of the Gender, or {@link Constants#GENDER_UNKNOWN_CODE} if null.
     */
    @Override
    public Integer convertToDatabaseColumn(final Gender attribute) {
        if (Objects.isNull(attribute)) {
            return GENDER_UNKNOWN_CODE;
        }
        return attribute.getCode();
    }

    /**
     * Converts a database column representation (Integer) to its corresponding Gender enum.
     *
     * @param dbData The integer representation from the database.
     * @return The Gender enum, or {@link Gender#UNKNOWN} if null or not found.
     */
    @Override
    public Gender convertToEntityAttribute(final Integer dbData) {
        if (Objects.isNull(dbData)) {
            return Gender.UNKNOWN;
        }
        return Gender.fromCode(dbData);
    }
}
