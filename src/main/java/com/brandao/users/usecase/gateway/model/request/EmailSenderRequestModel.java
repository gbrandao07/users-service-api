package com.brandao.users.usecase.gateway.model.request;

import java.util.Objects;

public class EmailSenderRequestModel {

    private final String senderEmail;
    private final String receiverEmail;
    private final String subject;
    private final String bodyText;

    public EmailSenderRequestModel(String senderEmail, String receiverEmail, String subject, String bodyText) {
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.subject = subject;
        this.bodyText = bodyText;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public String getSubject() {
        return subject;
    }

    public String getBodyText() {
        return bodyText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailSenderRequestModel that = (EmailSenderRequestModel) o;
        return Objects.equals(senderEmail, that.senderEmail) &&
                Objects.equals(receiverEmail, that.receiverEmail) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(bodyText, that.bodyText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senderEmail, receiverEmail, subject, bodyText);
    }

    @Override
    public String toString() {
        return "EmailSenderRequestModel{" +
                "senderEmail='" + senderEmail + '\'' +
                ", receiverEmail='" + receiverEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", bodyText='" + bodyText + '\'' +
                '}';
    }
}
