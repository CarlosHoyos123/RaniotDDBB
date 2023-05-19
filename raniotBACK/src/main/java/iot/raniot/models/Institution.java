package iot.raniot.models;

import jakarta.persistence.*;

@Entity
@Table(name = "institucion")
public class Institution {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_inst")
    private int  id;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="director",nullable = false)
    private Employee  director;
    @Column(name = "pais")
    private String cuntry;
    @Column(name = "departamento")
    private String  department;
    @Column(name = "municipio")
    private String region;
    @Column(name = "razon_social")
    private String name;
    @Column(name = "direccion")
    private String adress;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "correo")
    private String mail;
    @Column(name = "nit")
    private String nit;
    @Column(name = "estado")
    private String estate;

    public Institution() {
    }

    public Institution(int id, Employee director, String cuntry, String department, String region, String name, String adress, String phone, String mail, String nit, String estate) {

        this.id = id;
        this.director = director;
        this.cuntry = cuntry;
        this.department = department;
        this.region = region;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.mail = mail;
        this.nit = nit;
        this.estate = estate;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", director=" + director +
                ", cuntry='" + cuntry + '\'' +
                ", department='" + department + '\'' +
                ", region='" + region + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", nit='" + nit + '\'' +
                ", estate='" + estate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }

    public String getCuntry() {
        return cuntry;
    }

    public void setCuntry(String cuntry) {
        this.cuntry = cuntry;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }
}
