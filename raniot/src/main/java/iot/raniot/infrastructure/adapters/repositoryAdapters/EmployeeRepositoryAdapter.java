package iot.raniot.infrastructure.adapters.repositoryAdapters;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.gateways.EmployeeRepositoryGateway;
import iot.raniot.infrastructure.adapters.entity.EmployeeDBO;
import iot.raniot.infrastructure.adapters.repositoriesInterfaces.EmployeeDBORepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryAdapter implements EmployeeRepositoryGateway {

    private EmployeeDBORepository employeeDBORepository;

    @Override
    public Mono<EmployeeDBO> save(Employee employee) {
        EmployeeDBO employeeDBO = EmployeeDBO.fromDomain(employee);
        return employeeDBORepository.save(employeeDBO);
    }

    @Override
    public Mono findById(Employee employee) {
        return null;
    }

    @Override
    public Mono delete(Employee employee) {
        return null;
    }
}
