package iot.raniot.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = "registros")

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
    @JoinColumn(name="UIDenv")
    private Tag_endoscope  endoscope;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="UIDemp")
    private Tags_employe worker;
    @Column(name = "D1")
    private String stage1;
    @Column(name = "D2")
    private String stage2;
    @Column(name = "D3")
    private String stage3;
    @Column(name = "D4")
    private String stage4;
    @Column(name = "D5")
    private String stage5;
    @Column(name = "D6")
    private String stage6;
    @Column(name = "D7")
    private String stage7;
    @Column(name = "Limp_previa")
    private boolean priorCleaning;
    @Column(name = "PH_Enzimatico")
    private float PHSoap;
    @Column(name = "PH_Desinfectante")
    private float PHDisifectant;
    @Column(name = "novedad")
    private String alert;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="serie")
    private Iotdevice device;

    public Reprocess() {
    }

    public Reprocess(int id, LocalDate date, LocalTime time, Tag_endoscope endoscope, Tags_employe worker, String stage1, String stage2, String stage3, String stage4, String stage5, String stage6, String stage7, boolean priorCleaning, float PHSoap, float PHDisifectant, String alert, Iotdevice device) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.endoscope = endoscope;
        this.worker = worker;
        this.stage1 = stage1;
        this.stage2 = stage2;
        this.stage3 = stage3;
        this.stage4 = stage4;
        this.stage5 = stage5;
        this.stage6 = stage6;
        this.stage7 = stage7;
        this.priorCleaning = priorCleaning;
        this.PHSoap = PHSoap;
        this.PHDisifectant = PHDisifectant;
        this.alert = alert;
        this.device = device;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Tag_endoscope getEndoscope() {
        return endoscope;
    }

    public void setEndoscope(Tag_endoscope endoscope) {
        this.endoscope = endoscope;
    }

    public Tags_employe getWorker() {
        return worker;
    }

    public void setWorker(Tags_employe worker) {
        this.worker = worker;
    }

    public String getStage1() {
        return stage1;
    }

    public void setStage1(String stage1) {
        this.stage1 = stage1;
    }

    public String getStage2() {
        return stage2;
    }

    public void setStage2(String stage2) {
        this.stage2 = stage2;
    }

    public String getStage3() {
        return stage3;
    }

    public void setStage3(String stage3) {
        this.stage3 = stage3;
    }

    public String getStage4() {
        return stage4;
    }

    public void setStage4(String stage4) {
        this.stage4 = stage4;
    }

    public String getStage5() {
        return stage5;
    }

    public void setStage5(String stage5) {
        this.stage5 = stage5;
    }

    public String getStage6() {
        return stage6;
    }

    public void setStage6(String stage6) {
        this.stage6 = stage6;
    }

    public String getStage7() {
        return stage7;
    }

    public void setStage7(String stage7) {
        this.stage7 = stage7;
    }

    public boolean isPriorCleaning() {
        return priorCleaning;
    }

    public void setPriorCleaning(boolean priorCleaning) {
        this.priorCleaning = priorCleaning;
    }

    public float getPHSoap() {
        return PHSoap;
    }

    public void setPHSoap(float PHSoap) {
        this.PHSoap = PHSoap;
    }

    public float getPHDisifectant() {
        return PHDisifectant;
    }

    public void setPHDisifectant(float PHDisifectant) {
        this.PHDisifectant = PHDisifectant;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public Iotdevice getDevice() {
        return device;
    }

    public void setDevice(Iotdevice device) {
        this.device = device;
    }
}
