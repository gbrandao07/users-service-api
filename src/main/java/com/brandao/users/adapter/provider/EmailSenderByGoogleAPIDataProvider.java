package com.brandao.users.adapter.provider;

import com.brandao.users.usecase.gateway.EmailSenderGateway;
import com.brandao.users.usecase.gateway.model.request.EmailSenderRequestModel;
import com.brandao.users.usecase.gateway.model.response.EmailSenderResponseModel;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderByGoogleAPIDataProvider implements EmailSenderGateway {

    @Override
    public EmailSenderResponseModel verify(EmailSenderRequestModel requestModel) {
        // TODO implement feature
        return new EmailSenderResponseModel(true, "");
    }
}
