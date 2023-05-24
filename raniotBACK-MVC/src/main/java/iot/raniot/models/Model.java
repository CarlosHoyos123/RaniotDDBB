package iot.raniot.models;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo")
public class Model {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private int id;
    @Column(name = "modelo")
    private int model;
    @Column(name = "fecha_cracion")
    private int madeDate;

    public Model() {
    }

    public Model(int id, int model, int madeDate) {
        this.id = id;
        this.model = model;
        this.madeDate = madeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getMadeDate() {
        return madeDate;
    }

    public void setMadeDate(int madeDate) {
        this.madeDate = madeDate;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", model=" + model +
                ", madeDate=" + madeDate +
                '}';
    }
}
