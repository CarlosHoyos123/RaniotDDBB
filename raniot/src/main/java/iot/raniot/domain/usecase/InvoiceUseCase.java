package iot.raniot.domain.usecase;

import iot.raniot.domain.model.Invoice;
import iot.raniot.domain.model.gateways.InvoiceRepositoryGateway;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class InvoiceUseCase {

    private  final InvoiceRepositoryGateway invoiceRepositoryGateway;

    public InvoiceUseCase(InvoiceRepositoryGateway invoiceRepositoryGateway) {
        this.invoiceRepositoryGateway = invoiceRepositoryGateway;
    }

    public Mono saveInvoice(Invoice invoice){
        return  invoiceRepositoryGateway.save(invoice);
    }

    public Flux<Invoice> getInvoices(){
        return invoiceRepositoryGateway.findAll();
    }
}
