package iot.raniot.models;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "empleados")
public class Employee {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id;
    @Column(name = "institucion")
    private int institution;
    @Column(name = "nombre")
    private String name;
    @Column(name = "direccion")
    private String adress;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "correo")
    private String mail;
    @Column(name = "edad")
    private String age;
    @Column(name = "sexo")
    private String sex;
    @Column(name = "fecha_ingreso")
    private LocalDate since;
    @Column(name = "fecha_retiro")
    private LocalDate until;
    @Column(name = "es_instructor")
    private Boolean instructor;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="cargo", nullable = false)
    private Job job;

    public Employee() {
    }

    public Employee(int id, int institution, String name, String adress, String phone, String mail, String age, String sex, LocalDate since, LocalDate until, Boolean instructor, Job job) {
        this.id = id;
        this.institution = institution;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.mail = mail;
        this.age = age;
        this.sex = sex;
        this.since = since;
        this.until = until;
        this.instructor = instructor;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstitution() {
        return institution;
    }

    public void setInstitution(int institution) {
        this.institution = institution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public Boolean getInstructor() {
        return instructor;
    }

    public void setInstructor(Boolean instructor) {
        this.instructor = instructor;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", institution=" + institution +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", since=" + since +
                ", until=" + until +
                ", instructor=" + instructor +
                ", job=" + job +
                '}';
    }
}
