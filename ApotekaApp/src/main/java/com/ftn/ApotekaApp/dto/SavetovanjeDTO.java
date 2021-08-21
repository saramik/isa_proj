package com.ftn.ApotekaApp.dto;

public class SavetovanjeDTO {

    private Long id;

    private String datum;

    private String pocetakTermina;

    private String krajTermina;

    private String strucnoLice;

    public SavetovanjeDTO(Long id, String datum, String pocetakTermina, String krajTermina, String strucnoLice) {
        this.id = id;
        this.datum = datum;
        this.pocetakTermina = pocetakTermina;
        this.krajTermina = krajTermina;
        this.strucnoLice = strucnoLice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getPocetakTermina() {
        return pocetakTermina;
    }

    public void setPocetakTermina(String pocetakTermina) {
        this.pocetakTermina = pocetakTermina;
    }

    public String getKrajTermina() {
        return krajTermina;
    }

    public void setKrajTermina(String krajTermina) {
        this.krajTermina = krajTermina;
    }

    public String getStrucnoLice() {
        return strucnoLice;
    }

    public void setStrucnoLice(String strucnoLice) {
        this.strucnoLice = strucnoLice;
    }
}
