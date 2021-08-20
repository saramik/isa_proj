package com.ftn.ApotekaApp.dto;

import javax.validation.constraints.NotBlank;

public class ApotekaDTO {

    private Long id;

    private String naziv;

    private String grad;

    private String adresa;

    public ApotekaDTO(Long id, String naziv, String grad, String adresa) {
        this.id = id;
        this.naziv = naziv;
        this.grad = grad;
        this.adresa = adresa;
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

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
