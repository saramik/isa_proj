package com.ftn.ApotekaApp.dto;

import java.util.List;

public class RezervacijaDTO {

    private Long id;

    private String datumIzdavanja;

    private boolean preuzeto;

    private ApotekaDTO apoteka;

    private List<LekDTO> lekovi;

    public RezervacijaDTO() {
    }

    public RezervacijaDTO(Long id, String datumIzdavanja, boolean preuzeto, ApotekaDTO apoteka, List<LekDTO> lekovi) {
        this.id = id;
        this.datumIzdavanja = datumIzdavanja;
        this.preuzeto = preuzeto;
        this.apoteka = apoteka;
        this.lekovi = lekovi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(String datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public boolean isPreuzeto() {
        return preuzeto;
    }

    public void setPreuzeto(boolean preuzeto) {
        this.preuzeto = preuzeto;
    }

    public ApotekaDTO getApoteka() {
        return apoteka;
    }

    public void setApoteka(ApotekaDTO apoteka) {
        this.apoteka = apoteka;
    }

    public List<LekDTO> getLekovi() {
        return lekovi;
    }

    public void setLekovi(List<LekDTO> lekovi) {
        this.lekovi = lekovi;
    }
}
