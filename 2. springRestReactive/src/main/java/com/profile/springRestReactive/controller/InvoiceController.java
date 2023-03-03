package com.profile.springRestReactive.controller;

import com.profile.springRestReactive.entity.Invoice;
import com.profile.springRestReactive.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/save")
    public Mono<Invoice> saveOneInvoice(@RequestBody Invoice invoice){
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/allInvoices")
    public Flux<Invoice> getAllInvoices(){
        return invoiceService.findAllInvoices();
    }

    @GetMapping("/get/{id}")
    public Mono<Invoice> getOneInvoice(@PathVariable Integer id){
        Mono<Invoice> invoice= invoiceService.getOneInvoice(id);
        return invoice;
    }

    @DeleteMapping("/delete/{id}")
    public Mono<String> deleteInvoice(@PathVariable Integer id){
        invoiceService.deleteInvoice(id);
        return Mono.just("Invoice with id: " +id+ " deleted !");
    }

}
