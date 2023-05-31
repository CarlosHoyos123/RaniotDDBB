package iot.raniot.domain.model;

import java.time.LocalDate;

public class IotDevice {
    private String serie;
    private String model;
    private Institution institution;
    private LocalDate madeDate;
    private Employee installBy;

    public String getSerie() {
        return serie;
    }

    public String getModel() {
        return model;
    }

    public Institution getInstitution() {
        return institution;
    }

    public LocalDate getMadeDate() {
        return madeDate;
    }

    public Employee getInstallBy() {
        return installBy;
    }

    public IotDevice(String serie, String model, Institution institution, LocalDate madeDate, Employee installBy) {
        this.serie = serie;
        this.model = model;
        this.institution = institution;
        this.madeDate = madeDate;
        this.installBy = installBy;
    }
}
