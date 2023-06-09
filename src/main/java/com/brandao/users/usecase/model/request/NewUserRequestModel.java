package com.brandao.users.usecase.model.request;

import java.util.Objects;

public class NewUserRequestModel {

    private final String id;
    private final String cpf;
    private final String email;
    private final String name;
    private final String gender;
    private final String age;
    private final String docUrl;

    public NewUserRequestModel(String id, String cpf, String email, String name, String gender, String age, String docUrl) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.docUrl = docUrl;
    }

    public String getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getDocUrl() {
        return docUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUserRequestModel that = (NewUserRequestModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(email, that.email) &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(age, that.age) &&
                Objects.equals(docUrl, that.docUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, email, name, gender, age, docUrl);
    }

    @Override
    public String toString() {
        return "NewUserRequestModel{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", docUrl='" + docUrl + '\'' +
                '}';
    }
}
