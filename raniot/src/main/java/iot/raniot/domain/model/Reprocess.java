package iot.raniot.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reprocess {
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

    public Reprocess(Long id, LocalDate date, LocalTime time, String endoscope, String employee, int stage1, int stage2, boolean priorCleaning, Double phSoap, Double phDisinfectant, String alert, IotDevice idDevice) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.endoscope = endoscope;
        this.employee = employee;
        this.stage1 = stage1;
        this.stage2 = stage2;
        this.priorCleaning = priorCleaning;
        this.phSoap = phSoap;
        this.phDisinfectant = phDisinfectant;
        this.alert = alert;
        this.idDevice = idDevice;
    }
}
