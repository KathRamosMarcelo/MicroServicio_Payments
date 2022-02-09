package pe.com.bancaempresas.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bancaempresas.model.Payments;
import reactor.core.publisher.Flux;

@Repository
public interface PaymentsRepository extends ReactiveMongoRepository<Payments, Integer>{
    //busqueda por nombre
	//Flux<Payments>findByFirstnameLike(String expString );
}
