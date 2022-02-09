package pe.com.bancaempresas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bancaempresas.model.Payments;
import pe.com.bancaempresas.repository.PaymentsRepository;
import pe.com.bancaempresas.service.PaymentsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentsServiceImpl implements PaymentsService{

	//https://everisgroup-my.sharepoint.com/personal/esanchra_emeal_nttdata_com/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fesanchra%5Femeal%5Fnttdata%5Fcom%2FDocuments%2FGrabaciones%2FBootCamp%20Microservicios%20%2D%20Feb2022%2D20220207%5F103920%2DGrabaci%C3%B3n%20de%20la%20reuni%C3%B3n%2Emp4&parent=%2Fpersonal%2Fesanchra%5Femeal%5Fnttdata%5Fcom%2FDocuments%2FGrabaciones
	//MIN 1:07:21
	@Autowired
	PaymentsRepository paymentsRepository;

	@Override
	public void createPay(Payments payments) {
		paymentsRepository.save(payments).subscribe();

	}

	@Override
	public Mono<Payments> findByPayId(Integer id) {
		return paymentsRepository.findById(id);
	}

	@Override
	public Flux<Payments> findAllPay() {
		return paymentsRepository.findAll();
	}

	@Override
	public Mono<Payments> updatePay(Payments payments) {
		return paymentsRepository.save(payments);
	}

	@Override
	public Mono<Void> deletePay(Integer id) {
		return paymentsRepository.deleteById(id);
	}
}
