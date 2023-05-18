package iot.raniot.models;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = " ")
public class Employee {

    @Id
    @GeneratedValue
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
    @JoinColumn(name="cargo")
    private int job;




}
