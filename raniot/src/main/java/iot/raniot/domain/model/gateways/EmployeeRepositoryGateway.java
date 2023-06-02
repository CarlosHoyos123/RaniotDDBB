package iot.raniot.domain.model.gateways;

import iot.raniot.domain.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepositoryGateway {
    Mono save(Employee employee);

    Mono findById(Employee employee);

    Mono delete(Employee employee);
}
