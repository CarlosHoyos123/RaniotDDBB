package iot.raniot.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "equipos_IoT")
public class Iotdevice {

    @Id
    @Column(name = "serie")
    private String serie;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="modelo")
    private Model model;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="institucion")
    private Institution institution;
    @Column(name = "fecha_fabricacion")
    private LocalDate madeDate;
    @Column(name = "instalo")
    private String installBy;

    public Iotdevice() {
    }

    public Iotdevice(String serie, Model model, Institution institution, LocalDate madeDate, String installBy) {
        this.serie = serie;
        this.model = model;
        this.institution = institution;
        this.madeDate = madeDate;
        this.installBy = installBy;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public LocalDate getMadeDate() {
        return madeDate;
    }

    public void setMadeDate(LocalDate madeDate) {
        this.madeDate = madeDate;
    }

    public String getInstallBy() {
        return installBy;
    }

    public void setInstallBy(String installBy) {
        this.installBy = installBy;
    }

    @Override
    public String toString() {
        return "Iotdevice{" +
                "serie='" + serie + '\'' +
                ", model=" + model +
                ", institution=" + institution +
                ", madeDate=" + madeDate +
                ", installBy='" + installBy + '\'' +
                '}';
    }
}
