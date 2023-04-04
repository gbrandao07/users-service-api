package com.brandao.users.usecase.gateway.model.request;

import java.util.Objects;

public class DocumentValidatorRequestModel {

    private final String docUrl;

    public DocumentValidatorRequestModel(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getDocUrl() {
        return docUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentValidatorRequestModel that = (DocumentValidatorRequestModel) o;
        return Objects.equals(docUrl, that.docUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docUrl);
    }

    @Override
    public String toString() {
        return "DocumentValidatorRequestModel{" +
                "docUrl='" + docUrl + '\'' +
                '}';
    }
}
