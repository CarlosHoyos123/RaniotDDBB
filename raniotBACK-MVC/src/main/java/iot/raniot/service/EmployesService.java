package iot.raniot.service;

import iot.raniot.models.Employee;
import iot.raniot.models.Institution;

import java.util.List;

public interface EmployesService {
    List<Employee> listByInstitution(Institution inst);
    List<Employee> instructorsList();
}
