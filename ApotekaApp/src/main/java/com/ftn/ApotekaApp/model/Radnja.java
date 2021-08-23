package com.ftn.ApotekaApp.model;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Table(name="radnje")
@Inheritance(strategy=SINGLE_TABLE)
@SequenceGenerator(name="radnja_generator",initialValue = 5 ,sequenceName = "radnja_seq")
@DiscriminatorColumn(name="type", discriminatorType=STRING)
public class Radnja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "radnja_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private LocalDate datum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="termin_id", nullable=false)
    private Termin termin;

    @ManyToOne()
    @JoinColumn(name="strlice_id", nullable=false)
    private StrucnoLice strucnoLice;

    @OneToOne(mappedBy = "radnja", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Izvestaj izvestaj;

    public Radnja() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public StrucnoLice getStrucnoLice() {
        return strucnoLice;
    }

    public void setStrucnoLice(StrucnoLice strucnoLice) {
        this.strucnoLice = strucnoLice;
    }

    public Izvestaj getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(Izvestaj izvestaj) {
        this.izvestaj = izvestaj;
    }
}
