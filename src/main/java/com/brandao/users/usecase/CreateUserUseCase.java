package com.brandao.users.usecase;

import com.brandao.users.entity.User;
import com.brandao.users.entity.types.Gender;
import com.brandao.users.usecase.exception.BadUserException;
import com.brandao.users.usecase.exception.CouldNotSendEmailException;
import com.brandao.users.usecase.exception.CouldNotValidateDocumentException;
import com.brandao.users.usecase.exception.CouldNotVerifyCpfException;
import com.brandao.users.usecase.gateway.CpfVerifierGateway;
import com.brandao.users.usecase.gateway.DocumentValidatorGateway;
import com.brandao.users.usecase.gateway.EmailSenderGateway;
import com.brandao.users.usecase.gateway.model.request.CpfVerifierRequestModel;
import com.brandao.users.usecase.gateway.model.request.DocumentValidatorRequestModel;
import com.brandao.users.usecase.gateway.model.request.EmailSenderRequestModel;
import com.brandao.users.usecase.gateway.model.response.CpfVerifierResponseModel;
import com.brandao.users.usecase.gateway.model.response.DocumentValidatorResponseModel;
import com.brandao.users.usecase.gateway.model.response.EmailSenderResponseModel;
import com.brandao.users.usecase.model.request.NewUserRequestModel;
import com.brandao.users.usecase.model.response.NewUserResponseModel;

public class CreateUserUseCase {

    private CpfVerifierGateway cpfVerifierGateway;
    private DocumentValidatorGateway documentValidatorGateway;
    private EmailSenderGateway emailSenderGateway;

    public CreateUserUseCase(CpfVerifierGateway cpfVerifierGateway, DocumentValidatorGateway documentValidatorGateway, EmailSenderGateway emailSenderGateway) {
        this.cpfVerifierGateway = cpfVerifierGateway;
        this.documentValidatorGateway = documentValidatorGateway;
        this.emailSenderGateway = emailSenderGateway;
    }

    public NewUserResponseModel execute(NewUserRequestModel requestModel) {

        try {

            Integer age = requestModel.getAge() == null || requestModel.getAge().isEmpty() ? 0 : Integer.parseInt(requestModel.getAge());
            User user = new User(
                    requestModel.getId(),
                    requestModel.getCpf(),
                    requestModel.getEmail(),
                    requestModel.getName(),
                    Gender.fromString(requestModel.getGender()),
                    age,
                    requestModel.getDocUrl()
            );

            if (!user.isValid()) {
                throw new BadUserException("User Data is invalid: " + user);
            }

            CpfVerifierRequestModel cpfVerifierRequestModel = new CpfVerifierRequestModel(requestModel.getCpf());
            CpfVerifierResponseModel cpfVerifierResponseModel = cpfVerifierGateway.verify(cpfVerifierRequestModel);
            if (!cpfVerifierResponseModel.isSucceeded()) {
                throw new CouldNotVerifyCpfException("Could not verify CPF: " + cpfVerifierResponseModel.getErrorMessage());
            }

            DocumentValidatorRequestModel documentValidatorRequestModel = new DocumentValidatorRequestModel(requestModel.getDocUrl());
            DocumentValidatorResponseModel documentValidatorResponseModel = documentValidatorGateway.verify(documentValidatorRequestModel);
            if (!documentValidatorResponseModel.isSucceeded()) {
                throw new CouldNotValidateDocumentException("Could not validate document: " + documentValidatorResponseModel.getErrorMessage());
            }

            EmailSenderRequestModel emailSenderRequestModel = new EmailSenderRequestModel("cadastro@test.com", requestModel.getEmail(), "Some subject!", "Some text!");
            EmailSenderResponseModel emailSenderResponseModel = emailSenderGateway.verify(emailSenderRequestModel);
            if (!emailSenderResponseModel.isSucceeded()) {
                throw new CouldNotSendEmailException("Could not send email: " + emailSenderResponseModel.getErrorMessage());
            }

            return new NewUserResponseModel(true, "");

        } catch (BadUserException | CouldNotVerifyCpfException | CouldNotValidateDocumentException | CouldNotSendEmailException e) {
            return new NewUserResponseModel(false, e.getMessage());
        }
    }
}
