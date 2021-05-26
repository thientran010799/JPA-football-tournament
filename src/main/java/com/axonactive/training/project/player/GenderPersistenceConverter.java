package com.axonactive.training.project.player;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderPersistenceConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        return (attribute != null)? attribute.getValue() : null;
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        Gender gender = Gender.UNKNOWN;
        for (Gender each : Gender.values()) {
            if (each.getValue() == dbData) {
                gender = each;
            }
        }
        return gender;
    }

}
