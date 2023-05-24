package iot.raniot;

import iot.raniot.models.Employee;
import iot.raniot.repositories.EmployeeRepositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class integraciónJpaTest {
    @Autowired
    EmployeeRepositories employeeRepositories;

    @Test
    void employeeRepositoriesTest(){
        System.out.println(employeeRepositories.findAll());

    }
}
