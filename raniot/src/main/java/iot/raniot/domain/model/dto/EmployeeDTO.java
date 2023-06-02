package iot.raniot.domain.model.dto;

import iot.raniot.domain.model.Employee;
import java.time.LocalDate;

public class EmployeeDTO {

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
    private JobDTO job;

    public EmployeeDTO(long id, int institution, String name, String surName, String lastname, String surLastName, String adress, String phone, String mail, int age, char sex, LocalDate inDate, LocalDate withdrawalDate, boolean instructor, JobDTO job) {
        this.institution = institution;
        this.name = name;
        this.surName = surName;
        this.lastname = lastname;
        this.surLastName = surLastName;
        this.adress = adress;
        this.phone = phone;
        this.mail = mail;
        this.age = age;
        this.sex = sex;
        this.inDate = inDate;
        this.withdrawalDate = withdrawalDate;
        this.instructor = instructor;
        this.job = job;
    }

    public Employee toDomain( ){
        return new Employee(
            id, institution, name, surName, lastname, surLastName,
            adress, phone, mail, age, sex, inDate, withdrawalDate, instructor, job.toDomain());
    }

    public static EmployeeDTO fromDomain(Employee employee){
        return new EmployeeDTO(
            employee.getId(),employee.getInstitution(), employee.getName(), employee.getSurName(),
            employee.getLastname(), employee.getSurLastName(), employee.getAdress(),
            employee.getPhone(), employee.getMail(), employee.getAge(), employee.getSex(),
            employee.getInDate(), employee.getWithdrawalDate(), employee.isInstructor(),
            JobDTO.fromDomain(employee.getJob()));
    }
}
