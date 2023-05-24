package iot.raniot.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tags_endoscopios")
public class Tag_endoscope {

    @Id
    @Column(name = "UIDenv")
    private String id;
    @Column(name = "modelo")
    private String model;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="institucion")
    private Institution institution;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="empresa_mtto")
    private Maintainer maintainer;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="equipo_IoT")
    private Iotdevice device;

    public Tag_endoscope() {
    }

    public Tag_endoscope(String id, String model, Institution institution, Maintainer maintainer, Iotdevice device) {
        this.id = id;
        this.model = model;
        this.institution = institution;
        this.maintainer = maintainer;
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Maintainer getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(Maintainer maintainer) {
        this.maintainer = maintainer;
    }

    public Iotdevice getDevice() {
        return device;
    }

    public void setDevice(Iotdevice device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Tag_endoscope{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", institution=" + institution +
                ", maintainer=" + maintainer +
                ", device=" + device +
                '}';
    }
}
