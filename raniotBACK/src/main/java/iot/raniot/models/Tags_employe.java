package iot.raniot.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tags_empleados")
public class Tags_employe {

    @Id
    @Column(name = "UIDemp")
    private String UID;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="equipo_IoT")
    private Iotdevice device;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="empleado")
    private Employee  employee;

    public Tags_employe() {
    }

    public Tags_employe(String UID, Iotdevice device) {
        this.UID = UID;
        this.device = device;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public Iotdevice getDevice() {
        return device;
    }

    public void setDevice(Iotdevice device) {
        this.device = device;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Tags_employe{" +
                "UID='" + UID + '\'' +
                ", device=" + device +
                ", employee=" + employee +
                '}';
    }
}
