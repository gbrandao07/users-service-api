package com.brandao.users.adapter.provider;

import com.brandao.users.usecase.gateway.CpfVerifierGateway;
import com.brandao.users.usecase.gateway.model.request.CpfVerifierRequestModel;
import com.brandao.users.usecase.gateway.model.response.CpfVerifierResponseModel;
import org.springframework.stereotype.Service;

@Service
public class CpfVerifierByCountryDatabaseDataProvider implements CpfVerifierGateway {

    @Override
    public CpfVerifierResponseModel verify(CpfVerifierRequestModel requestModel) {
        // TODO implement feature
        return new CpfVerifierResponseModel(true, "");
    }
}
