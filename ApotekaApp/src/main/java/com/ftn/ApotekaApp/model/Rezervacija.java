package com.ftn.ApotekaApp.model;

import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rezervacija_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy="id")
    private Set<Lek> lekovi;

    @Column
    private LocalDate datum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="apoteka_id", nullable=false)
    private Apoteka apoteka;

    @Column
    private boolean preuzeto;

    public Rezervacija() {}

    public Rezervacija(Long id, Set<Lek> lekovi, LocalDate datum) {
        this.id = id;
        this.lekovi = lekovi;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Lek> getLekovi() {
        return lekovi;
    }

    public void setLekovi(Set<Lek> lekovi) {
        this.lekovi = lekovi;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
