package com.example.company_management_system.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


import java.sql.Timestamp;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Timestamp> {

        @Override
        public Timestamp convertToDatabaseColumn(LocalDate localDate) {
            return localDate != null ? Timestamp.valueOf(localDate.atStartOfDay()) :null;
        }

        @Override
        public LocalDate convertToEntityAttribute(Timestamp timestamp) {
            return timestamp != null ? timestamp.toLocalDateTime().toLocalDate() : null;
        }
    }

