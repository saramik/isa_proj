package com.ftn.ApotekaApp.model;

import javax.persistence.*;

@Entity
public class Zalba {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zalba_generator")
    @SequenceGenerator(name="zalba_generator",initialValue = 1, sequenceName = "zalba_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String tekst;

    public Zalba() {
    }

    public Zalba(Long id, String tekst) {
        this.id = id;
        this.tekst = tekst;
    }

    public Zalba(String tekst) {
        this.tekst = tekst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
