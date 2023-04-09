package com.brandao.users.usecase;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {

    @Mock
    private CpfVerifierGateway cpfVerifierGateway;

    @Mock
    private DocumentValidatorGateway documentValidatorGateway;

    @Mock
    private EmailSenderGateway emailSenderGateway;

    @InjectMocks
    private CreateUserUseCase useCase;

    @Test
    public void given_ValidUserData_should_createWithSuccess() {

        // Given

        NewUserRequestModel requestModel = new NewUserRequestModel("1a2b3c",
                "444 444 000 01",
                "gustavob@test.com",
                "Gustavo B",
                "male",
                "29",
                "somelink.com/doc01.png"
        );

        CpfVerifierRequestModel cpfVerifierRequestModel = new CpfVerifierRequestModel(requestModel.getCpf());
        CpfVerifierResponseModel cpfVerifierResponseModel = new CpfVerifierResponseModel(true, "");
        when(cpfVerifierGateway.verify(cpfVerifierRequestModel)).thenReturn(cpfVerifierResponseModel);

        DocumentValidatorRequestModel documentValidatorRequestModel = new DocumentValidatorRequestModel(requestModel.getDocUrl());
        DocumentValidatorResponseModel documentValidatorResponseModel = new DocumentValidatorResponseModel(true, "");
        when(documentValidatorGateway.verify(documentValidatorRequestModel)).thenReturn(documentValidatorResponseModel);

        EmailSenderRequestModel emailSenderRequestModel = new EmailSenderRequestModel("cadastro@test.com", requestModel.getEmail(), "Some subject!", "Some text!");
        EmailSenderResponseModel emailSenderResponseModel = new EmailSenderResponseModel(true, "");
        when(emailSenderGateway.verify(emailSenderRequestModel)).thenReturn(emailSenderResponseModel);

        // When

        NewUserResponseModel responseModel = useCase.execute(requestModel);

        // Then

        assertEquals(true, responseModel.getSuccess());
        assertEquals("", responseModel.getErrorMessage());

    }

    @Test
    public void given_BadUserData_should_throw_BadUserException() {

        // Given

        NewUserRequestModel requestModel = new NewUserRequestModel(
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        );

        // When

        NewUserResponseModel responseModel = useCase.execute(requestModel);

        // Then

        assertTrue(responseModel.getErrorMessage().contains("User Data is invalid: "));
    }

    @Test
    public void given_ValidUserData_When_CPF_HasRestrictions_should_throw_CouldNotVerifyCpfException() {

        // Given

        NewUserRequestModel requestModel = new NewUserRequestModel("1a2b3c",
                "444 444 000 01",
                "gustavob@test.com",
                "Gustavo B",
                "male",
                "29",
                "somelink.com/doc01.png"
        );

        CpfVerifierRequestModel cpfVerifierRequestModel = new CpfVerifierRequestModel(requestModel.getCpf());
        CpfVerifierResponseModel cpfVerifierResponseModel = new CpfVerifierResponseModel(false, "CPF has restrictions!!!");
        when(cpfVerifierGateway.verify(cpfVerifierRequestModel)).thenReturn(cpfVerifierResponseModel);


        // When

        NewUserResponseModel responseModel = useCase.execute(requestModel);

        // Then

        assertTrue(responseModel.getErrorMessage().contains("Could not verify CPF: "));
    }

    @Test
    public void given_ValidUserData_When_Document_isValid_should_throw_CouldNotValidateDocumentException() {

        // Given

        NewUserRequestModel requestModel = new NewUserRequestModel("1a2b3c",
                "444 444 000 01",
                "gustavob@test.com",
                "Gustavo B",
                "male",
                "29",
                "somelink.com/doc01.png"
        );

        CpfVerifierRequestModel cpfVerifierRequestModel = new CpfVerifierRequestModel(requestModel.getCpf());
        CpfVerifierResponseModel cpfVerifierResponseModel = new CpfVerifierResponseModel(true, "");
        when(cpfVerifierGateway.verify(cpfVerifierRequestModel)).thenReturn(cpfVerifierResponseModel);

        DocumentValidatorRequestModel documentValidatorRequestModel = new DocumentValidatorRequestModel(requestModel.getDocUrl());
        DocumentValidatorResponseModel documentValidatorResponseModel = new DocumentValidatorResponseModel(false, "The provided document does not match the user data");
        when(documentValidatorGateway.verify(documentValidatorRequestModel)).thenReturn(documentValidatorResponseModel);

        // When

        NewUserResponseModel responseModel = useCase.execute(requestModel);

        // Then

        assertTrue(responseModel.getErrorMessage().contains("Could not validate document: "));
    }

    @Test
    public void given_ValidUserData_When_FailToSendEmail_should_throw_CouldNotSendEmailException() {

        // Given

        NewUserRequestModel requestModel = new NewUserRequestModel("1a2b3c",
                "444 444 000 01",
                "gustavob@test.com",
                "Gustavo B",
                "male",
                "29",
                "somelink.com/doc01.png"
        );

        CpfVerifierRequestModel cpfVerifierRequestModel = new CpfVerifierRequestModel(requestModel.getCpf());
        CpfVerifierResponseModel cpfVerifierResponseModel = new CpfVerifierResponseModel(true, "");
        when(cpfVerifierGateway.verify(cpfVerifierRequestModel)).thenReturn(cpfVerifierResponseModel);

        DocumentValidatorRequestModel documentValidatorRequestModel = new DocumentValidatorRequestModel(requestModel.getDocUrl());
        DocumentValidatorResponseModel documentValidatorResponseModel = new DocumentValidatorResponseModel(true, "");
        when(documentValidatorGateway.verify(documentValidatorRequestModel)).thenReturn(documentValidatorResponseModel);

        EmailSenderRequestModel emailSenderRequestModel = new EmailSenderRequestModel("cadastro@test.com", requestModel.getEmail(), "Some subject!", "Some text!");
        EmailSenderResponseModel emailSenderResponseModel = new EmailSenderResponseModel(false, "Timeout in STMP server");
        when(emailSenderGateway.verify(emailSenderRequestModel)).thenReturn(emailSenderResponseModel);

        // When

        NewUserResponseModel responseModel = useCase.execute(requestModel);

        // Then

        assertTrue(responseModel.getErrorMessage().contains("Could not send email: "));
    }


}
