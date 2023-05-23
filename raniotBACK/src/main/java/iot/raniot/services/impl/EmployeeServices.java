package iot.raniot.services.impl;

import iot.raniot.models.Employee;
import iot.raniot.models.Institution;
import iot.raniot.repositories.EmployeeRepositories;
import iot.raniot.service.EmployesService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServices implements EmployesService {

    EmployeeRepositories employeeRepositories;

    public EmployeeServices(EmployeeRepositories employeeRepositories) {
        this.employeeRepositories = employeeRepositories;
    }

    @Override
    public List<Employee> listByInstitution(Institution inst) {
        return employeeRepositories.findByInstitution(inst.getId());
    }

    @Override
    public List<Employee> instructorsList() {
        return employeeRepositories.findByInstructor(true);
    }

    public List<Employee>  searchAll(){
        return (List<Employee>) employeeRepositories.findAll();
    }
}
