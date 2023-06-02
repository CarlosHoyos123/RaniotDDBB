package iot.raniot.infrastructure.adapters.repositoryAdapters;

import iot.raniot.domain.model.Institution;
import iot.raniot.domain.model.gateways.InstitutionRepositoryGateway;
import iot.raniot.infrastructure.adapters.entity.InstitutionDBO;
import iot.raniot.infrastructure.adapters.repositoriesInterfaces.InstitutionDBORepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class InstitutionDBORepositoryAdapter  implements InstitutionRepositoryGateway {

    private InstitutionDBORepository institutionDBORepository;
    @Override
    public Mono<Institution> save(Institution institution) {
        Mono<InstitutionDBO> res = institutionDBORepository.save(InstitutionDBO.fromDomain(institution));
        return res.map(InstitutionDBO::toDomain);
    }

    @Override
    public Mono findById(Institution institution) {
        return null;
    }
}
