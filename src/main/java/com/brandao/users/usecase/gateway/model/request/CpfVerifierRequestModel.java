package com.brandao.users.usecase.gateway.model.request;

import java.util.Objects;

public class CpfVerifierRequestModel {

    private final String cpf;

    public CpfVerifierRequestModel(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CpfVerifierRequestModel that = (CpfVerifierRequestModel) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "CpfVerifierRequestModel{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
