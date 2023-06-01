package iot.raniot.domain.usecase;

import iot.raniot.domain.model.Institution;
import iot.raniot.domain.model.gateways.InstitutionRepositoryGateway;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class InstitutionUseCase {

    private InstitutionRepositoryGateway institutionRepositoryGateway;

    public Mono saveInstitution(Institution institution){
        return  institutionRepositoryGateway.save(institution);
    }

    public Mono <Institution> findInstitutionById(Institution institution){
        return institutionRepositoryGateway.findById(institution);
    }
}
