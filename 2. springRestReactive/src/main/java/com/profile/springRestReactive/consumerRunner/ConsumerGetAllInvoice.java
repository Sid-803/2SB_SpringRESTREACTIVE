package com.profile.springRestReactive.consumerRunner;

import com.profile.springRestReactive.entity.Invoice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class ConsumerGetAllInvoice implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        WebClient client = WebClient.create("http://localhost:8080");
        Flux<Invoice> flux= client
                .get()
                .uri("/invoice/allInvoices")
                .retrieve()
                .bodyToFlux(Invoice.class);
        ((Flux<?>) flux).doOnNext(System.out::println).blockLast();
    }
}
