package iot.raniot.infrastructure.adapters.repositoriesInterfaces;

import iot.raniot.infrastructure.adapters.entity.EmployeeDBO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDBORepository extends ReactiveCrudRepository<EmployeeDBO, Long> {

}
