package iot.raniot.domain.usecase;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.gateways.EmployeeRepositoryGateway;
import iot.raniot.infrastructure.adapters.repositoryAdapters.EmployeeRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class EmployeeUseCase {

    private EmployeeRepositoryGateway employeeRepositoryGateway;

    public Mono<Employee> saveEmployee(Employee employee){
        return employeeRepositoryGateway.save(employee);
    }

    public Mono<Employee> findEmployeeById(Employee employee){
        return employeeRepositoryGateway.findById(employee);
    }

    public Mono<Employee> deleteEmployee(Employee employee){
        return  employeeRepositoryGateway.delete(employee);
    }
}
