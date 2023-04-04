package com.brandao.users.adapter;

import com.brandao.users.usecase.CreateUserUseCase;
import com.brandao.users.usecase.gateway.CpfVerifierGateway;
import com.brandao.users.usecase.gateway.DocumentValidatorGateway;
import com.brandao.users.usecase.gateway.EmailSenderGateway;
import com.brandao.users.usecase.model.request.NewUserRequestModel;
import com.brandao.users.usecase.model.response.NewUserResponseModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ComponentTest {


    @Autowired
    private CpfVerifierGateway cpfVerifierGateway;

    @Autowired
    private DocumentValidatorGateway documentValidatorGateway;

    @Autowired
    private EmailSenderGateway emailSenderGateway;

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

        CreateUserUseCase useCase = new CreateUserUseCase(cpfVerifierGateway, documentValidatorGateway, emailSenderGateway);

        // When
        NewUserResponseModel responseModel = useCase.execute(requestModel);

        // Then
        assertTrue(responseModel.getSuccess());
        assertEquals("", responseModel.getErrorMessage());

    }
}
