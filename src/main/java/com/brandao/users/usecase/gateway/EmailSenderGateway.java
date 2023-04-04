package com.brandao.users.usecase.gateway;

import com.brandao.users.usecase.gateway.model.request.EmailSenderRequestModel;
import com.brandao.users.usecase.gateway.model.response.EmailSenderResponseModel;

public interface EmailSenderGateway {

    EmailSenderResponseModel verify(EmailSenderRequestModel requestModel);
}
