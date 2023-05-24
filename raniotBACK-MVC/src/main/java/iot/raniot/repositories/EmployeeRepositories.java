package iot.raniot.repositories;

import iot.raniot.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepositories extends CrudRepository<Employee, Long> {

    List<Employee> findByInstitution(int inst);

    List<Employee> findByInstructor(boolean isInstructor);

}
