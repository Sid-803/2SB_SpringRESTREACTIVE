package com.profile.springRestReactive.repository;

import com.profile.springRestReactive.entity.Invoice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface InvoiceRepo extends ReactiveMongoRepository<Invoice, Integer> {

}
