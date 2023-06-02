package iot.raniot.domain.model;
import java.time.LocalDate;

public class Employee {
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
    private Job job;

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
    public Job getJob() {
        return job;
    }

    public Employee(long id, int institution, String name, String surName, String lastname, String surLastName, String adress, String phone, String mail, int age, char sex, LocalDate inDate, LocalDate withdrawalDate, boolean instructor, Job job) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", institution=" + institution +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", surLastName='" + surLastName + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", inDate=" + inDate +
                ", withdrawalDate=" + withdrawalDate +
                ", instructor=" + instructor +
                ", job=" + job +
                '}';
    }
}