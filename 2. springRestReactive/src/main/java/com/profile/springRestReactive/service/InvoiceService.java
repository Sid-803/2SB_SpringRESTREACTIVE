package com.profile.springRestReactive.service;

import com.profile.springRestReactive.entity.Invoice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InvoiceService {
    public Mono<Invoice> saveInvoice(Invoice invoice);

    public Flux<Invoice> findAllInvoices();

    public Mono<Invoice> getOneInvoice(Integer id);

    public Mono<Void> deleteInvoice(Integer id);
}
