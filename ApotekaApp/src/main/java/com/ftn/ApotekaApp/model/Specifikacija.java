package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Specifikacija{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specifikacija_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToOne(mappedBy = "specifikacija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Lek lek;

    @Column(name="kontraindikacija", unique=false, nullable=false)
    private String kontraindikacija;

    @Column(name="sastav", unique=false, nullable=false)
    private String sastav;

    @Column(name="proizvodjac", unique=false, nullable=false)
    private String proizvodjac;

    @Column(name="preporuceni_unos", unique=false, nullable=false)
    private Integer preporuceniUnos;

    @OneToMany(mappedBy="id")
    private Set<Lek> zamenski;

    public Specifikacija() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lek getLek() {
        return lek;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }

    public String getKontraindikacija() {
        return kontraindikacija;
    }

    public void setKontraindikacija(String kontraindikacija) {
        this.kontraindikacija = kontraindikacija;
    }

    public String getSastav() {
        return sastav;
    }

    public void setSastav(String sastav) {
        this.sastav = sastav;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public Integer getPreporuceniUnos() {
        return preporuceniUnos;
    }

    public void setPreporuceniUnos(Integer preporuceniUnos) {
        this.preporuceniUnos = preporuceniUnos;
    }

    public Set<Lek> getZamenski() {
        return zamenski;
    }

    public void setZamenski(Set<Lek> zamenski) {
        this.zamenski = zamenski;
    }
}
