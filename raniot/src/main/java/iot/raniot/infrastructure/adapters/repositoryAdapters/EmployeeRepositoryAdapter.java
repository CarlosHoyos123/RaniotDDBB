package iot.raniot.infrastructure.adapters.repositoryAdapters;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.gateways.EmployeeRepositoryGateway;
import iot.raniot.infrastructure.adapters.entity.EmployeeDBO;
import iot.raniot.infrastructure.adapters.repositoriesInterfaces.EmployeeDBORepository;
import reactor.core.publisher.Mono;


public class EmployeeRepositoryAdapter implements EmployeeRepositoryGateway {

    private EmployeeDBORepository employeeDBORepository;

    @Override
    public Mono<EmployeeDBO> save(Employee employee) {
        return employeeDBORepository.save(EmployeeDBO.fromDomain(employee));
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