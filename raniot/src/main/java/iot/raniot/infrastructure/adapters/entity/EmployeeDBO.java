package iot.raniot.infrastructure.adapters.entity;

import iot.raniot.domain.model.Employee;
import org.springframework.data.annotation.Id;
import lombok.Builder;
import java.time.LocalDate;

@Builder
public class EmployeeDBO {
    @Id
    private long id ;
    private int institution ;
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
    private String job;

    public Employee toDomain(EmployeeDBO employeeDBO){
        return new Employee(
                employeeDBO.getId(), employeeDBO.getInstitution(), employeeDBO.getName(), employeeDBO.getSurName(),
                employeeDBO.getLastname(), employeeDBO.getSurLastName(), employeeDBO.getAdress(),
                employeeDBO.getPhone(), employeeDBO.getMail(), employeeDBO.getAge(), employeeDBO.getSex(),
                employeeDBO.getInDate(), employeeDBO.getWithdrawalDate(),
                employeeDBO.isInstructor(),employeeDBO.getJob());
    }

    public static EmployeeDBO fromDomain(Employee employee){
        return EmployeeDBO.builder()
            .id(employee.getId())
            .institution(employee.getInstitution())
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
            .job(employee.getJob())
        .build();
    }
    public long getId() {
        return id;
    }

    public int getInstitution() {
        return institution;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSurLastName() {
        return surLastName;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getInDate() {
        return inDate;
    }

    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }

    public boolean isInstructor() {
        return instructor;
    }

    public String getJob() {
        return job;
    }
}
