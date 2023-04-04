package com.brandao.users.usecase.exception;

public class CouldNotSendEmailException extends Exception {

    public CouldNotSendEmailException(String cause) {
        super(cause);
    }
}
