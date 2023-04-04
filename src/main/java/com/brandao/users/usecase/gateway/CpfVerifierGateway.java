package com.brandao.users.usecase.gateway;

import com.brandao.users.usecase.gateway.model.request.CpfVerifierRequestModel;
import com.brandao.users.usecase.gateway.model.response.CpfVerifierResponseModel;

public interface CpfVerifierGateway {

    CpfVerifierResponseModel verify(CpfVerifierRequestModel requestModel);
}
