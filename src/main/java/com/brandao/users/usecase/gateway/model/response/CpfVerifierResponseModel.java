package com.brandao.users.usecase.gateway.model.response;

import java.util.Objects;

public class CpfVerifierResponseModel {

    private final boolean succeeded;
    private final String errorMessage;

    public CpfVerifierResponseModel(boolean succeeded, String errorMessage) {
        this.succeeded = succeeded;
        this.errorMessage = errorMessage;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CpfVerifierResponseModel that = (CpfVerifierResponseModel) o;
        return succeeded == that.succeeded &&
                Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(succeeded, errorMessage);
    }

    @Override
    public String toString() {
        return "CpfVerifierResponseModel{" +
                "succeeded=" + succeeded +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
