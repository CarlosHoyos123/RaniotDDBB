package iot.raniot.application.configuration;

import iot.raniot.domain.model.gateways.*;
import iot.raniot.domain.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfiguration {

    @Bean
    public EmployeeUseCase employeeUseCase(EmployeeRepositoryGateway employeeRepositoryGateway){
        return new EmployeeUseCase(employeeRepositoryGateway);
    }
/*    @Bean
    public InstitutionUseCase institutionUseCase(InstitutionRepositoryGateway institutionRepositoryGateway){
        return  new InstitutionUseCase(institutionRepositoryGateway);
    }
    @Bean
    public InvoiceUseCase invoiceUseCase(InvoiceRepositoryGateway invoiceRepositoryGateway){
        return  new InvoiceUseCase(invoiceRepositoryGateway);
    }
    @Bean
    public IotdeviceUseCase iotdeviceUseCase(IotDeviceRepositoryGateway iotDeviceRepositoryGateway){
        return  new IotdeviceUseCase(iotDeviceRepositoryGateway);
    }
    @Bean
    public PriceUseCase priceUseCase(PriceRepositoryGateway priceRepositoryGateway){
        return new PriceUseCase(priceRepositoryGateway);
    }
    @Bean
    public ReprocessUseCase reprocessUseCase(ReprocessRepositoryGateway reprocessRepositoryGateway){
        return new ReprocessUseCase(reprocessRepositoryGateway);
    }*/
}
