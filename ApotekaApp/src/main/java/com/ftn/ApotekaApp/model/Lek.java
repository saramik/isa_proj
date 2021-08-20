package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lek {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lek_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="naziv", unique=false, nullable=false)
    private String naziv;

    @Column(name="sifra", unique=true, nullable=false)
    private String sifra;

    @Column(name="tip_leka", unique=false, nullable=false)
    private TipLeka tipLeka;

    @Column(name="oblik_leka", unique=false, nullable=false)
    private OblikLeka oblikLeka;

    @Column(name="rezim", unique=false, nullable=false)
    private boolean rezim;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "specifikacija_id")
    private Specifikacija specifikacija;

    @OneToMany(mappedBy="id")
    private Set<LekDostupnost> dostupnostApoteka;

    public Lek() {
    }

    public Lek(Long id, String naziv, String sifra, TipLeka tipLeka, OblikLeka oblikLeka, boolean rezim, Specifikacija specifikacija, Set<LekDostupnost> dostupnostApoteka) {
        this.id = id;
        this.naziv = naziv;
        this.sifra = sifra;
        this.tipLeka = tipLeka;
        this.oblikLeka = oblikLeka;
        this.rezim = rezim;
        this.specifikacija = specifikacija;
        this.dostupnostApoteka = dostupnostApoteka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public TipLeka getTipLeka() {
        return tipLeka;
    }

    public void setTipLeka(TipLeka tipLeka) {
        this.tipLeka = tipLeka;
    }

    public OblikLeka getOblikLeka() {
        return oblikLeka;
    }

    public void setOblikLeka(OblikLeka oblikLeka) {
        this.oblikLeka = oblikLeka;
    }

    public boolean isRezim() {
        return rezim;
    }

    public void setRezim(boolean rezim) {
        this.rezim = rezim;
    }

    public Specifikacija getSpecifikacija() {
        return specifikacija;
    }

    public void setSpecifikacija(Specifikacija specifikacija) {
        this.specifikacija = specifikacija;
    }

    public Set<LekDostupnost> getDostupnostApoteka() {
        return dostupnostApoteka;
    }

    public void setDostupnostApoteka(Set<LekDostupnost> dostupnostApoteka) {
        this.dostupnostApoteka = dostupnostApoteka;
    }
}
