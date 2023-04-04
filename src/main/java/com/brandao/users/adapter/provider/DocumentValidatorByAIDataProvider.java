package com.brandao.users.adapter.provider;

import com.brandao.users.usecase.gateway.DocumentValidatorGateway;
import com.brandao.users.usecase.gateway.model.request.DocumentValidatorRequestModel;
import com.brandao.users.usecase.gateway.model.response.DocumentValidatorResponseModel;
import org.springframework.stereotype.Service;

@Service
public class DocumentValidatorByAIDataProvider implements DocumentValidatorGateway {

    @Override
    public DocumentValidatorResponseModel verify(DocumentValidatorRequestModel requestModel) {
        // TODO implement feature
        return new DocumentValidatorResponseModel(true, "");
    }
}
