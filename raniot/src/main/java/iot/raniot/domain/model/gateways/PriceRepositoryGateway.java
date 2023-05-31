package iot.raniot.domain.model.gateways;

import iot.raniot.domain.model.Price;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PriceRepositoryGateway {
    Mono save(Price price);

    Flux<Price> findAll();
}
