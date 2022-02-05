package pe.com.bancaempresas.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.bancaempresas.model.Employee;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer>{

}
