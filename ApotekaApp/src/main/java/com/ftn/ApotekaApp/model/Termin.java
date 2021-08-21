package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Entity
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "termin_generator")
    @SequenceGenerator(name="termin_generator",initialValue = 3, sequenceName = "termin_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "termin_pocetak")
    private LocalTime pocetakTermina;

    @Column(name = "termin_kraj")
    private LocalTime krajTermina;

    public Termin() {}

    public Termin(Long id, LocalTime pocetakTermina, LocalTime krajTermina) {
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.krajTermina = krajTermina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getPocetakTermina() {
        return pocetakTermina;
    }

    public void setPocetakTermina(LocalTime pocetakTermina) {
        this.pocetakTermina = pocetakTermina;
    }

    public LocalTime getKrajTermina() {
        return krajTermina;
    }

    public void setKrajTermina(LocalTime krajTermina) {
        this.krajTermina = krajTermina;
    }
}
