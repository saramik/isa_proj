package com.ftn.ApotekaApp.dto;

import javax.validation.constraints.NotBlank;

public class LekDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String naziv;

    @NotBlank
    private String sifra;

    public LekDTO() {
    }

    public LekDTO(Long id, String naziv, String sifra) {
        this.id = id;
        this.naziv = naziv;
        this.sifra = sifra;
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

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
}
