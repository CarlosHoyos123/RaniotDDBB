package iot.raniot.repositories;

import iot.raniot.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositories extends CrudRepository<Employee, Long> {

}
