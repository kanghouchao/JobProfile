package com.kang.resume.infrastructure.external;

import com.kang.resume.domain.model.entity.Gender;
import jakarta.persistence.AttributeConverter;

import java.util.Objects;

/**
 * @author kanghouchao
 */
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        if (Objects.isNull(attribute)) {
            return 10;
        }
        return attribute.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData)) {
            return Gender.UNKNOWN;
        }
        return Gender.fromCode(dbData);
    }
}