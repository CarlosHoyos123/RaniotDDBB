package iot.raniot.domain.usecase;

import iot.raniot.domain.model.Reprocess;
import iot.raniot.domain.model.gateways.ReprocessRepositoryGateway;
import reactor.core.publisher.Mono;


public class ReprocessUseCase {
    private final ReprocessRepositoryGateway reprocessRepositoryGateway;

    public ReprocessUseCase(ReprocessRepositoryGateway reprocessRepositoryGateway) {
        this.reprocessRepositoryGateway = reprocessRepositoryGateway;
    }

    public Mono createReprocess(Reprocess reprocess){
        return reprocessRepositoryGateway.save(reprocess);
    }

    public Mono getReprocess(Long id ){
        return reprocessRepositoryGateway.getById(id);
    }
}
