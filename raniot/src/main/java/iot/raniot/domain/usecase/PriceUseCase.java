package iot.raniot.domain.usecase;

import iot.raniot.domain.model.Price;
import iot.raniot.domain.model.gateways.PriceRepositoryGateway;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class PriceUseCase {

    private final PriceRepositoryGateway priceRepositoryGateway;

    public PriceUseCase(PriceRepositoryGateway priceRepositoryGateway) {
        this.priceRepositoryGateway = priceRepositoryGateway;
    }

    public Mono savePrice(Price price){
        return priceRepositoryGateway.save(price);
    }

    public Flux<Price> getPrice (){
        return priceRepositoryGateway.findAll();
    }
}
