package com.brandao.users.adapter.config;

import com.brandao.users.adapter.provider.CpfVerifierByCountryDatabaseDataProvider;
import com.brandao.users.adapter.provider.DocumentValidatorByAIDataProvider;
import com.brandao.users.adapter.provider.EmailSenderByGoogleAPIDataProvider;
import com.brandao.users.usecase.gateway.CpfVerifierGateway;
import com.brandao.users.usecase.gateway.DocumentValidatorGateway;
import com.brandao.users.usecase.gateway.EmailSenderGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersServiceApiDIConfig {

    @Bean
    public CpfVerifierGateway cpfVerifierGateway() {
        return new CpfVerifierByCountryDatabaseDataProvider();
    }

    @Bean
    public DocumentValidatorGateway documentValidatorGateway() {
        return new DocumentValidatorByAIDataProvider();
    }

    @Bean
    public EmailSenderGateway emailSenderGateway() {
        return new EmailSenderByGoogleAPIDataProvider();
    }
}
