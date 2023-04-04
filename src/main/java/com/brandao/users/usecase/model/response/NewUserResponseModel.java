package com.brandao.users.usecase.model.response;

import java.util.Objects;

public class NewUserResponseModel {

    private Boolean success;
    private String errorMessage;

    public NewUserResponseModel(Boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUserResponseModel that = (NewUserResponseModel) o;
        return Objects.equals(success, that.success) &&
                Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, errorMessage);
    }

    @Override
    public String toString() {
        return "SendEmailWithProspectUserDataToVendedorResponseModel{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
