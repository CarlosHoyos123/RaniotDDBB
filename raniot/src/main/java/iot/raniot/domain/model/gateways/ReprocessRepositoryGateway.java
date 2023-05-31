package iot.raniot.domain.model.gateways;

import iot.raniot.domain.model.Reprocess;
import reactor.core.publisher.Mono;

public interface ReprocessRepositoryGateway {
    Mono save(Reprocess reprocess);

    Mono getById(Long id);

}
