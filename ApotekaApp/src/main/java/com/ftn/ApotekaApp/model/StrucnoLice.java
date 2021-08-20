package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("S")
public class StrucnoLice extends Korisnik{

    private TipStrucnogLica tipStrucnogLica;

    @OneToMany(mappedBy = "strucnoLice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RadnoVremeApoteka> radnoVremeApoteka;

    @OneToMany(mappedBy = "strucnoLice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Radnja> radnje;

    @Column(name="ocene")
    private String ocene;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pacijent> pacijenti;

    public StrucnoLice(Set<RadnoVremeApoteka> radnoVremeApoteka, Set<Radnja> radnje, String ocene, Set<Pacijent> pacijenti) {
        this.radnoVremeApoteka = radnoVremeApoteka;
        this.radnje = radnje;
        this.ocene = ocene;
        this.pacijenti = pacijenti;
    }

    public StrucnoLice(Long id, String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, boolean pretplacen, Set<RadnoVremeApoteka> radnoVremeApoteka, Set<Radnja> radnje, String ocene, Set<Pacijent> pacijenti) {
        super(id, email, lozinka, ime, prezime, adresa, grad, drzava, broj, pretplacen);
        this.radnoVremeApoteka = radnoVremeApoteka;
        this.radnje = radnje;
        this.ocene = ocene;
        this.pacijenti = pacijenti;
    }

    public StrucnoLice(Long id, String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, boolean pretplacen, TipStrucnogLica tipStrucnogLica, Set<RadnoVremeApoteka> radnoVremeApoteka, Set<Radnja> radnje, String ocene, Set<Pacijent> pacijenti) {
        super(id, email, lozinka, ime, prezime, adresa, grad, drzava, broj, pretplacen);
        this.tipStrucnogLica = tipStrucnogLica;
        this.radnoVremeApoteka = radnoVremeApoteka;
        this.radnje = radnje;
        this.ocene = ocene;
        this.pacijenti = pacijenti;
    }



    public StrucnoLice() {
    }

    public Set<RadnoVremeApoteka> getRadnoVremeApoteka() {
        return radnoVremeApoteka;
    }

    public void setRadnoVremeApoteka(Set<RadnoVremeApoteka> radnoVremeApoteka) {
        this.radnoVremeApoteka = radnoVremeApoteka;
    }

    public Set<Radnja> getRadnje() {
        return radnje;
    }

    public void setRadnje(Set<Radnja> radnje) {
        this.radnje = radnje;
    }

    public List<Integer> getOcene() {
        List<Integer> lstVals = new ArrayList<Integer>();
        int val = 0;

        for(String field : this.ocene.split(",")) {
            try {
                val = Integer.parseInt(field);
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

    public Set<Pacijent> getPacijenti() {
        return pacijenti;
    }

    public void setPacijenti(Set<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    public TipStrucnogLica getTipStrucnogLica() {
        return tipStrucnogLica;
    }

    public void setTipStrucnogLica(TipStrucnogLica tipStrucnogLica) {
        this.tipStrucnogLica = tipStrucnogLica;
    }
}
