package pe.com.bancaempresas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.bancaempresas.model.Payments;
import pe.com.bancaempresas.service.impl.PaymentsServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentsController {
	@Autowired
	private PaymentsServiceImpl paymentsServiceImpl;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createPay(@RequestBody Payments payments) {
		paymentsServiceImpl.createPay(payments);
	}

	@GetMapping
	@ResponseBody
	public Flux<Payments> findAll() {
		return paymentsServiceImpl.findAllPay();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mono<Payments>> findPayById(@PathVariable("id") Integer id) {
		Mono<Payments> payments = paymentsServiceImpl.findByPayId(id);
		return new ResponseEntity<Mono<Payments>>(payments, payments != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Mono<Payments> update(@RequestBody Payments payments) {
		return paymentsServiceImpl.updatePay(payments);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable("id") Integer id) {
		paymentsServiceImpl.deletePay(id).subscribe();
	}
}
