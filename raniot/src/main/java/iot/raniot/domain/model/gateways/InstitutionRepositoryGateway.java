package iot.raniot.domain.model.gateways;

import iot.raniot.domain.model.Institution;
import reactor.core.publisher.Mono;

public interface InstitutionRepositoryGateway {

    Mono save(Institution institution);

    Mono findById(Institution institution);
}
