package com.ftn.ApotekaApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("P")
public class Pacijent extends Korisnik{

    @Column
    private Integer penali;

    @OneToMany(mappedBy="id")
    private List<Lek> alergijaLekovi;

    @OneToMany(mappedBy="id")
    private Set<Rezervacija> rezervacije;

    @OneToMany(mappedBy="id")
    private Set<ERecept> eRecepti;

    @OneToMany(mappedBy = "pacijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pregled> pregledi;

    @OneToMany(mappedBy = "pacijent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Savetovanje> savetovanja;

//    @ManyToMany(mappedBy = "projects")
//    private Set<Apoteka> apoteke; //gde je sve bio i rezervisao


    public Pacijent(Long id, String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, boolean pretplacen, Integer penali, List<Lek> alergijaLekovi, Set<Rezervacija> rezervacije, Set<ERecept> eRecepti, Set<Pregled> pregledi, Set<Savetovanje> savetovanja) {
        super(id, email, lozinka, ime, prezime, adresa, grad, drzava, broj, pretplacen);
        this.penali = penali;
        this.alergijaLekovi = alergijaLekovi;
        this.rezervacije = rezervacije;
        this.eRecepti = eRecepti;
        this.pregledi = pregledi;
        this.savetovanja = savetovanja;
    }

    public Pacijent(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, false, false, new ArrayList<>(), null);
        this.penali = 0;
        this.alergijaLekovi = new ArrayList<>();
        this.eRecepti = new HashSet<>();
        this.pregledi = new HashSet<>();
        this.rezervacije = new HashSet<>();
        this.savetovanja = new HashSet<>();
    }

    public Pacijent(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, ArrayList<Lek> lekovi) {
        super(email, lozinka, ime, prezime, adresa, grad, drzava, broj, false, false, new ArrayList<>(), null);
        this.penali = 0;
        this.alergijaLekovi = lekovi;
        this.eRecepti = new HashSet<>();
        this.pregledi = new HashSet<>();
        this.rezervacije = new HashSet<>();
        this.savetovanja = new HashSet<>();
    }

    public Pacijent() {
    }

    public Integer getPenali() {
        return penali;
    }

    public void setPenali(Integer penali) {
        this.penali = penali;
    }

    public List<Lek> getAlergijaLekovi() {
        return alergijaLekovi;
    }

    public void setAlergijaLekovi(List<Lek> alergijaLekovi) {
        this.alergijaLekovi = alergijaLekovi;
    }

    public Set<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public Set<ERecept> geteRecepti() {
        return eRecepti;
    }

    public void seteRecepti(Set<ERecept> eRecepti) {
        this.eRecepti = eRecepti;
    }

    public Set<Pregled> getPregledi() {
        return pregledi;
    }

    public void setPregledi(Set<Pregled> pregledi) {
        this.pregledi = pregledi;
    }

    public Set<Savetovanje> getSavetovanja() {
        return savetovanja;
    }

    public void setSavetovanja(Set<Savetovanje> savetovanja) {
        this.savetovanja = savetovanja;
    }
}
