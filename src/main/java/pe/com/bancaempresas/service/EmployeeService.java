package pe.com.bancaempresas.service;

import pe.com.bancaempresas.model.Employee;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface EmployeeService {
	void createEmploye(Employee employe);
    
    Mono<Employee> findByEmpId(Integer id);
 
    Flux<Employee> findAllEmp();
 
    Mono<Employee> updateEmp(Employee employe);
 
    Mono<Void> deleteEmp(Integer id);
}
