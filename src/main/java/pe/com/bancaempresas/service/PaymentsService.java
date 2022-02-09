package pe.com.bancaempresas.service;

import pe.com.bancaempresas.model.Payments;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentsService {
	void createPay(Payments payments);
    
    Mono<Payments> findByPayId(Integer id);
 
    Flux<Payments> findAllPay();
 
    Mono<Payments> updatePay(Payments payments);
 
    Mono<Void> deletePay(Integer id);
}
