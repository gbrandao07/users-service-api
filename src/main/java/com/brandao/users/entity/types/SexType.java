package com.brandao.users.entity.types;

public enum SexType {

    MALE,
    FEMALE,
    TRANSGER,
    OTHER,
    NOT_INFORMED;

    public static SexType fromString(String text) {
        switch (text.toLowerCase()) {
            case "male":
                return MALE;
            case "female":
                return FEMALE;
            case "transger":
                return TRANSGER;
            case "other":
                return OTHER;
            default:
                return NOT_INFORMED;
        }
    }
}
