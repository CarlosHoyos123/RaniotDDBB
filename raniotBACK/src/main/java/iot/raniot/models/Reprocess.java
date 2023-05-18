package iot.raniot.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = " ")

public class Reprocess {

    @Id
    @GeneratedValue
    @Column(name = "id_registro")
    private int id;
    @Column(name = "fecha")
    private LocalDate date;
    @Column(name = "hora")
    private LocalTime time;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="endoscopio")
    private String  endoscope;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="encargado")
    private String worker;
    @Column(name = "")
    private String D1;
    @Column(name = " ")
    private String D2;
    @Column(name = " ")
    private String D3;
    @Column(name = " ")
    private String D4;
    @Column(name = " ")
    private String D5;
    @Column(name = " ")
    private String D6;
    @Column(name = " ")
    private String D7;
    @Column(name = "Limp_previa")
    private boolean Limp_previa;
    @Column(name = "PH_Enzimatico")
    private float PH_Enzimatico;
    @Column(name = "PH_Desinfectante")
    private float PH_Desinfectante;
    @Column(name = "novedad")
    private String novedad;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="equipo_IoT")
    private String device;

}
