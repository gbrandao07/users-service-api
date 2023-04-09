package com.brandao.users.entity.types;

public enum Gender {

    MALE,
    FEMALE,
    TRANSGENDER,
    OTHER,
    NOT_INFORMED;

    public static Gender fromString(String text) {
        switch (text.toLowerCase()) {
            case "male":
                return MALE;
            case "female":
                return FEMALE;
            case "transgender":
                return TRANSGENDER;
            case "other":
                return OTHER;
            default:
                return NOT_INFORMED;
        }
    }
}
