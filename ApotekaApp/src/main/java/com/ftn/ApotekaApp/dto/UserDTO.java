package com.ftn.ApotekaApp.dto;

import com.ftn.ApotekaApp.model.Korisnik;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDTO {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;

    @NotBlank
    private String ime;

    @NotBlank
    private String prezime;

    @NotBlank
    private String adresa;

    @NotBlank
    private String grad;

    @NotBlank
    private String drzava;

    @NotBlank
    private String broj;

    private List<LekDTO> alergijeLekovi;

    private int penali;

    public UserDTO(Korisnik u){
        this.email = u.getEmail();
        this.password = u.getPassword();
    }

    public UserDTO(@NotBlank @Email String email, @NotBlank @Size(min = 4, message = "Password must be at least 4 characters long") String password, @NotBlank String ime, @NotBlank String prezime, @NotBlank String adresa, @NotBlank String grad, @NotBlank String drzava, @NotBlank String broj) {
        this.email = email;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
    }

    public UserDTO(@NotBlank @Email String email, @NotBlank @Size(min = 4, message = "Password must be at least 4 characters long") String password, @NotBlank String ime, @NotBlank String prezime, @NotBlank String adresa, @NotBlank String grad, @NotBlank String drzava, @NotBlank String broj, List<LekDTO> alergijeLekovi) {
        this.email = email;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
        this.alergijeLekovi = alergijeLekovi;
    }

    public UserDTO(@NotBlank @Email String email, @NotBlank @Size(min = 4, message = "Password must be at least 4 characters long") String password, @NotBlank String ime, @NotBlank String prezime, @NotBlank String adresa, @NotBlank String grad, @NotBlank String drzava, @NotBlank String broj, List<LekDTO> alergijeLekovi, int penali) {
        this.email = email;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
        this.alergijeLekovi = alergijeLekovi;
        this.penali = penali;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public UserDTO(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<LekDTO> getAlergijeLekovi() {
        return alergijeLekovi;
    }

    public void setAlergijeLekovi(List<LekDTO> alergijeLekovi) {
        this.alergijeLekovi = alergijeLekovi;
    }

    public int getPenali() {
        return penali;
    }

    public void setPenali(int penali) {
        this.penali = penali;
    }
}
