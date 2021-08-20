package com.ftn.ApotekaApp.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("P")
public class Pregled extends Radnja {

    @ManyToOne()
    @JoinColumn(name="tipPregleda_id", nullable=false)
    private TipPregleda tipPregleda;

    @Column(name="izvrsen", unique=false, nullable=false)
    private Boolean izvrsen;

    @Column(name = "definisan", unique = false, nullable = false)
    private Boolean definisan;

    @ManyToOne()
    @JoinColumn(name="pacijent_id", nullable=false)
    private Pacijent pacijent;

    public Pregled() {
    }

    public Pregled(TipPregleda tipPregleda, Boolean izvrsen, Boolean definisan, Pacijent pacijent) {
        this.tipPregleda = tipPregleda;
        this.izvrsen = izvrsen;
        this.definisan = definisan;
        this.pacijent = pacijent;
    }

    public TipPregleda getTipPregleda() {
        return tipPregleda;
    }

    public void setTipPregleda(TipPregleda tipPregleda) {
        this.tipPregleda = tipPregleda;
    }

    public Boolean getIzvrsen() {
        return izvrsen;
    }

    public void setIzvrsen(Boolean izvrsen) {
        this.izvrsen = izvrsen;
    }

    public Boolean getDefinisan() {
        return definisan;
    }

    public void setDefinisan(Boolean definisan) {
        this.definisan = definisan;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }
}
