package com.brandao.users.usecase.gateway;

import com.brandao.users.usecase.gateway.model.request.DocumentValidatorRequestModel;
import com.brandao.users.usecase.gateway.model.response.DocumentValidatorResponseModel;

public interface DocumentValidatorGateway {

    DocumentValidatorResponseModel verify(DocumentValidatorRequestModel requestModel);
}
