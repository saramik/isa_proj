package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="radnovremeapoteka")
public class RadnoVremeApoteka {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "radnovreme_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="apoteka_id", nullable=false)
    private Apoteka apoteka;

    @ManyToOne
    @JoinColumn(name="radnoVremeApoteka_id", nullable=false)
    private StrucnoLice strucnoLice;

    @Column(name="pocetak_rada", unique=false, nullable=true)
    private LocalTime pocetakRada;

    @Column(name="kraj_rada", unique=false, nullable=true)
    private LocalTime krajRada;

    public RadnoVremeApoteka() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apoteka getApoteka() {
        return apoteka;
    }

    public void setApoteka(Apoteka apoteka) {
        this.apoteka = apoteka;
    }

    public StrucnoLice getStrucnoLice() {
        return strucnoLice;
    }

    public void setStrucnoLice(StrucnoLice strucnoLice) {
        this.strucnoLice = strucnoLice;
    }

    public LocalTime getPocetakRada() {
        return pocetakRada;
    }

    public void setPocetakRada(LocalTime pocetakRada) {
        this.pocetakRada = pocetakRada;
    }

    public LocalTime getKrajRada() {
        return krajRada;
    }

    public void setKrajRada(LocalTime krajRada) {
        this.krajRada = krajRada;
    }
}
