package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LekDostupnost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lekd_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="lek_id", nullable=false)
    private Lek lek;

    @ManyToOne
    @JoinColumn(name="apoteka_id", nullable=false)
    private Apoteka apoteka;

    @Column
    private Integer kolicina;

    public LekDostupnost() {}

    public LekDostupnost(Long id, Lek lek, Apoteka apoteka, Integer kolicina) {
        this.id = id;
        this.lek = lek;
        this.apoteka = apoteka;
        this.kolicina = kolicina;
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

    public Apoteka getApoteka() {
        return apoteka;
    }

    public void setApoteka(Apoteka apoteka) {
        this.apoteka = apoteka;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }
}
