package com.ftn.ApotekaApp.model;

import javax.persistence.*;

@Entity
@Table(name="tip_pregleda")
public class TipPregleda {
    @Column(name = "tip", nullable = false)
    private EnumTipPregleda tip;

    @Column(name="cena", unique=false, nullable=false)
    private Double cena;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tip_pregleda_generator")
    @SequenceGenerator(name="tip_pregleda_generator",initialValue = 2, sequenceName = "tip_pregleda_seq")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="trajanje", unique=false, nullable=false)
    private Integer trajanje;

    public TipPregleda()
    {

    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public EnumTipPregleda getTip() {
        return tip;
    }

    public void setTip(EnumTipPregleda ime) {
        this.tip = ime;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
