package pe.com.bancaempresas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bancaempresas.model.Employee;
import pe.com.bancaempresas.repository.EmployeeRepository;
import pe.com.bancaempresas.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public void createEmploye(Employee employe) {
		employeeRepo.save(employe).subscribe();

	}

	@Override
	public Mono<Employee> findByEmpId(Integer id) {
		return employeeRepo.findById(id);
	}

	@Override
	public Flux<Employee> findAllEmp() {
		return employeeRepo.findAll();
	}

	@Override
	public Mono<Employee> updateEmp(Employee employe) {
		return employeeRepo.save(employe);
	}

	@Override
	public Mono<Void> deleteEmp(Integer id) {
		return employeeRepo.deleteById(id);
	}

}
