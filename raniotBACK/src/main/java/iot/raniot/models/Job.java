package iot.raniot.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cargos")

public class Job {
    @Id
    @GeneratedValue
    @Column(name = "id_cargo")
    private int id;
    @Column(name = "nombre_cargo")
    private String name;
    @Column(name = "descripcion")
    private String description;

}
