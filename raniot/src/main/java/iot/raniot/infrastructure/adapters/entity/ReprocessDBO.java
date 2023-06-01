package iot.raniot.infrastructure.adapters.entity;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.IotDevice;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "registros")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReprocessDBO {
    @Id
    private Long id ;
    private LocalDate date;
    private LocalTime time;
    private String endoscope ;
    private String employee;
    private int stage1;
    private int stage2;
    private boolean priorCleaning ;
    private Double phSoap;
    private Double phDisinfectant;
    private String alert;
    private IotDevice idDevice;

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getEndoscope() {
        return endoscope;
    }

    public String getEmployee() {
        return employee;
    }

    public int getStage1() {
        return stage1;
    }

    public int getStage2() {
        return stage2;
    }

    public boolean isPriorCleaning() {
        return priorCleaning;
    }

    public Double getPhSoap() {
        return phSoap;
    }

    public Double getPhDisinfectant() {
        return phDisinfectant;
    }

    public String getAlert() {
        return alert;
    }

    public IotDevice getIdDevice() {
        return idDevice;
    }

    /*public Employee toDomain(EmployeeDBO employeeDBO){
        return new Employee(employeeDBO.getId(),employeeDBO.getInstitution(),employeeDBO.getName(),
                employeeDBO.getSurName(),employeeDBO.getLastname(),employeeDBO.getSurLastName(),
                employeeDBO.getAdress(),employeeDBO.getPhone(), employeeDBO.getMail(),employeeDBO.getAge(),
                employeeDBO.getSex(), employeeDBO.getInDate(), employeeDBO.getWithdrawalDate(),
                employeeDBO.isInstructor(), employeeDBO.getJob());
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
                .inDate(employee.getInDate())
                .withdrawalDate(employee.getWithdrawalDate())
                .instructor(employee.isInstructor())
                .job(employee.getJob())
                .build();
    }*/
}
