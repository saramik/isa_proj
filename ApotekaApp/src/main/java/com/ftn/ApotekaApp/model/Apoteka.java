package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Apoteka {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apoteka_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="naziv", unique=false, nullable=false)
    private String naziv;

    @OneToMany(mappedBy="id")
    private Set<StrucnoLice> strucnaLica;

    @OneToMany(mappedBy="id")
    private Set<Rezervacija> rezervacije;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "apoteka_pacijenti", joinColumns = @JoinColumn(name = "apoteka_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "pacijent_id", referencedColumnName = "id"))
//    private Set<Pacijent> pacijenti; //kod rezervacije lekova da vidi sta je svaki pacijent rezervisao

    @OneToMany(mappedBy="id")
    private Set<LekDostupnost> dostupniLekovi;

    @Column(name="adresa", unique=false, nullable=false)
    private String adresa;

    @Column(name="grad", unique=false, nullable=false)
    private String grad;

    @Column(name="drzava", unique=false, nullable=false)
    private String drzava;

    @Column(name="ocene")
    private String ocene;

    @OneToMany(mappedBy="id")
    private Set<TipPregleda> tipoviPregleda;

    public Apoteka(Long id, String opis, Set<StrucnoLice> strucnaLica, Set<Rezervacija> rezervacije, Set<LekDostupnost> dostupniLekovi, String adresa, String grad, String drzava, String ocene, Set<TipPregleda> tipoviPregleda) {
        this.id = id;
        this.naziv = opis;
        this.strucnaLica = strucnaLica;
        this.rezervacije = rezervacije;
        this.dostupniLekovi = dostupniLekovi;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.ocene = ocene;
        this.tipoviPregleda = tipoviPregleda;
    }

    public Apoteka() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<StrucnoLice> getStrucnaLica() {
        return strucnaLica;
    }

    public void setStrucnaLica(Set<StrucnoLice> strucnaLica) {
        this.strucnaLica = strucnaLica;
    }

    public void setOcene(String ocene) {
        this.ocene = ocene;
    }

    public Set<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public Set<LekDostupnost> getDostupniLekovi() {
        return dostupniLekovi;
    }

    public void setDostupniLekovi(Set<LekDostupnost> dostupniLekovi) {
        this.dostupniLekovi = dostupniLekovi;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public List<Integer> getOcene() {
        List<java.lang.Integer> lstVals = new ArrayList<java.lang.Integer>();
        int val = 0;

        for(String field : this.ocene.split(",")) {
            try {
                val = java.lang.Integer.parseInt(field);
            }
            // If the String contains other thing that digits and commas
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            lstVals.add(val);
        }

        return lstVals;
    }

    public void setOcene(List<Integer> ocene) {
        StringBuilder newVals = new StringBuilder();
        for(int i : ocene) {
            newVals.append(String.valueOf(i));
            newVals.append(',');
        }
        this.ocene = newVals.toString();
    }

    public Set<TipPregleda> getTipoviPregleda() {
        return tipoviPregleda;
    }

    public void setTipoviPregleda(Set<TipPregleda> tipoviPregleda) {
        this.tipoviPregleda = tipoviPregleda;
    }
}
