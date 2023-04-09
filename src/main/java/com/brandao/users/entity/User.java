package com.brandao.users.entity;

import com.brandao.users.entity.types.Gender;

import java.util.Objects;

public class User {

    private final String id;
    private final String cpf;
    private final String email;
    private final String name;
    private final Gender gender;
    private final Integer age;
    private final String docUrl;

    public User(String id, String cpf, String email, String name, Gender gender, Integer age, String docUrl) {
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

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public boolean isValid() {
        if (id == null || id.isEmpty())
            return false;
        if (cpf == null || cpf.isEmpty())
            return false;
        if (email == null || email.isEmpty())
            return false;
        if (name == null || name.isEmpty())
            return false;
        if (gender == null)
            return false;
        if (age == null || age < 18)
            return false;
        if (docUrl == null || docUrl.isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(cpf, user.cpf) &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                gender == user.gender &&
                Objects.equals(age, user.age) &&
                Objects.equals(docUrl, user.docUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, email, name, gender, age, docUrl);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", docUrl='" + docUrl + '\'' +
                '}';
    }
}
