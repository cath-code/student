package com.cs.studentapi.student;

import java.util.stream.Stream;

public enum GenderType {
    FEMALE("F"),
    MALE("M");

    public final String description;

    GenderType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static GenderType of(String description) {
        return Stream.of(GenderType.values())
                .filter(p -> p.getDescription().equals(description))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
