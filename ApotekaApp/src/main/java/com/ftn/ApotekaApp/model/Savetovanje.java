package com.ftn.ApotekaApp.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("S")
public class Savetovanje  extends Radnja{

    @Column(name="izvrsen", unique=false, nullable=false)
    private Boolean izvrsen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pacijent_id", nullable=false)
    private Pacijent pacijent;

    public Savetovanje() {
    }

    public Boolean getIzvrsen() {
        return izvrsen;
    }

    public void setIzvrsen(Boolean izvrsen) {
        this.izvrsen = izvrsen;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }
}
