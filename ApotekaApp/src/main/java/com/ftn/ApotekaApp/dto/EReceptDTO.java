package com.ftn.ApotekaApp.dto;

import java.util.List;

public class EReceptDTO {
    private Long id;

    private String datumIzdavanja;

    private String status;

    private List<LekDTO> lekovi;

    public EReceptDTO(Long id, String datumIzdavanja, String status, List<LekDTO> lekovi) {
        this.id = id;
        this.datumIzdavanja = datumIzdavanja;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LekDTO> getLekovi() {
        return lekovi;
    }

    public void setLekovi(List<LekDTO> lekovi) {
        this.lekovi = lekovi;
    }
}
