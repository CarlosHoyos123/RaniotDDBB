package iot.raniot.infrastructure.adapters.entity;

import iot.raniot.domain.model.Employee;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.swing.*;
import java.time.LocalDate;

@Table(name = "empleados")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDBO {
    @Id
    private long id ;
    private InstitutionDBO institution ;
    private String name;
    private String surName;
    private String lastname;
    private String surLastName;
    private String adress;
    private String phone;
    private String mail;
    private int age;
    private char sex;
    private LocalDate inDate;
    private LocalDate withdrawalDate;
    private boolean instructor;
    private JobDBO job;

    public static Employee toDomain(EmployeeDBO employeeDBO){
        return new Employee(
                employeeDBO.getId(), InstitutionDBO.toDomain(employeeDBO.getInstitution()) , employeeDBO.getName(), employeeDBO.getSurName(),
                employeeDBO.getLastname(), employeeDBO.getSurLastName(), employeeDBO.getAdress(),
                employeeDBO.getPhone(), employeeDBO.getMail(), employeeDBO.getAge(), employeeDBO.getSex(),
                employeeDBO.getInDate(), employeeDBO.getWithdrawalDate(),
                employeeDBO.isInstructor(),JobDBO.toDomain(employeeDBO.getJob()));
    }

    public static EmployeeDBO fromDomain(Employee employee){
        return EmployeeDBO.builder()
            .id(employee.getId())
            .institution(InstitutionDBO.fromDomain(employee.getInstitution()))
            .name(employee.getName())
            .surName(employee.getSurName())
            .lastname(employee.getLastname())
            .surLastName(employee.getSurLastName())
            .adress(employee.getAdress())
            .phone(employee.getPhone())
            .mail(employee.getMail())
            .age(employee.getAge())
            .sex(employee.getSex())
            .instructor(employee.isInstructor())
            .job(JobDBO.fromDomain(employee.getJob()))
        .build();
    }
}
