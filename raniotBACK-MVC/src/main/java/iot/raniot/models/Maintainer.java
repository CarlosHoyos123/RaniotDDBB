package iot.raniot.models;

import jakarta.persistence.*;

@Entity
@Table(name = "empresas_mtto_DM")
public class Maintainer {

    @Id
    @Column(name = "id_nit")
    private String id;
    @Column(name = "razon_social")
    private String name;
    @Column(name = "ciudad")
    private String city;
    @Column(name = "direccion")
    private String adress;
    @Column(name = "telefono")
    private String phone;

    public Maintainer() {
    }

    public Maintainer(String id, String name, String city, String adress, String phone) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.adress = adress;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    @Override
    public String toString() {
        return "Maintainer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
