package com.profile.springRestReactive.serviceImpl;

import com.profile.springRestReactive.entity.Invoice;
import com.profile.springRestReactive.repository.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvoiceServiceImpl {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public Mono<Invoice> saveInvoice(Invoice invoice){
        return invoiceRepo.save(invoice);
    }

    public Flux<Invoice> findAllInvoices(){
        //return repo.findAll();
        return invoiceRepo.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Invoice> getOneInvoice(Integer id){
        return invoiceRepo.findById(id).switchIfEmpty(Mono.empty());
    }

    public Mono<Void> deleteInvoice(Integer id){
        return invoiceRepo.deleteById(id);
    }
}

