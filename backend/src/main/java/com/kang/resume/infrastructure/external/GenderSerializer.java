package com.kang.resume.infrastructure.external;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.kang.resume.domain.model.entity.Gender;

import java.io.IOException;
import java.util.Objects;

/**
 * @author kanghouchao
 */
public class GenderSerializer extends JsonSerializer<Gender> {
    @Override
    public void serialize(Gender gender, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (Objects.nonNull(gender)) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("code", gender.getCode());
            jsonGenerator.writeStringField("description", gender.getDesc());
            jsonGenerator.writeEndObject();
        }
    }
}
