package com.example.tutorial4Selasa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "dealer")
public class DealerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama")
    private String nama;

    @NotNull
    @Size(max = 50)
    @Column(name = "alamat")
    private String alamat;

    @NotNull
    @Column(name = "telp")
    private double telp;

    @OneToMany(mappedBy = "carDealer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CarModel> car;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getTelp() {
        return telp;
    }

    public void setTelp(double telp) {
        this.telp = telp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<CarModel> getCar() {
        return car;
    }

    public void setCar(List<CarModel> car) {
        this.car = car;
    }
}
