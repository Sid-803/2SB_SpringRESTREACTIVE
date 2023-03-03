package com.profile.springRestReactive.consumerRunner;

import com.profile.springRestReactive.entity.Invoice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ConsumerGetOneInvoice implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        WebClient client = WebClient.create("http://localhost:8080");
        Mono<Invoice> mono= client
                .get()
                .uri("/invoice/get/3")
                .retrieve()
                .bodyToMono(Invoice.class);
        mono.subscribe(System.out::println);
    }
}
