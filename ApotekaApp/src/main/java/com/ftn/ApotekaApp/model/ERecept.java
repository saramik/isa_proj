package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class ERecept {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "erecept_generator")
    @SequenceGenerator(name="erecept_generator",initialValue = 2 ,sequenceName = "erecept_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private LocalDate datumIzdavanja;

    @Column
    private StatusERecept status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pacijent pacijent;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "erecept_lekovi",
            joinColumns = @JoinColumn(name = "erecept_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lek_id", referencedColumnName = "id"))
    private Set<Lek> lekovi;

    @OneToOne(mappedBy = "eRecept", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Izvestaj izvestaj;

    public ERecept(Long id, LocalDate datumIzdavanja, StatusERecept status, Pacijent pacijent, Set<Lek> lekovi, Izvestaj izvestaj) {
        this.id = id;
        this.datumIzdavanja = datumIzdavanja;
        this.status = status;
        this.pacijent = pacijent;
        this.lekovi = lekovi;
        this.izvestaj = izvestaj;
    }

    public ERecept() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public StatusERecept getStatus() {
        return status;
    }

    public void setStatus(StatusERecept status) {
        this.status = status;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Set<Lek> getLekovi() {
        return lekovi;
    }

    public void setLekovi(Set<Lek> lekovi) {
        this.lekovi = lekovi;
    }

    public Izvestaj getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(Izvestaj izvestaj) {
        this.izvestaj = izvestaj;
    }
}
