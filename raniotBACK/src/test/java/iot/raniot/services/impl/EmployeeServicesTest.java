package iot.raniot.services.impl;

import iot.raniot.models.Employee;
import iot.raniot.models.Reprocess;
import iot.raniot.repositories.EmployeeRepositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static iot.raniot.Mockito.Data.*;
import static iot.raniot.Mockito.Data.reprocessList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServicesTest {


    @MockBean
    EmployeeRepositories employeeRepositories;

    @Autowired
    EmployeeServices service;

    @Test
    void listByInstitutionTest() {
        //Given
        when(employeeRepositories.findByInstitution(anyInt())).thenReturn(employeesList());
        //when
        List<Employee> resp = service.listByInstitution(newInstitution());
        //Then
        assertNotNull(resp);
        assertEquals(2, resp.size());
    }

    @Test
    void instructorsListTest() {
        //Given
        when(employeeRepositories.findByInstructor(anyBoolean())).thenReturn(employeesList());
        //when
        List<Employee> resp = service.employeeRepositories.findByInstructor(true);
        //Then
        assertNotNull(resp);
        assertEquals(2, resp.size());
    }

    @Test
    void searchAllTest() {
        //Given
        when(employeeRepositories.findAll()).thenReturn(employeesList());
        //when
        List<Employee> resp = service.searchAll();
        //Then
        assertNotNull(resp);
        assertEquals(2, resp.size());
    }
}