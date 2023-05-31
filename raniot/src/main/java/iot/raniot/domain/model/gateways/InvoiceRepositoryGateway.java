package iot.raniot.domain.model.gateways;

import iot.raniot.domain.model.Invoice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InvoiceRepositoryGateway {

    Mono save(Invoice invoice);

    Flux<Invoice> findAll();
}
