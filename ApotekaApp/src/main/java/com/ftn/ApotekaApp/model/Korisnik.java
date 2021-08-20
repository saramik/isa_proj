package com.ftn.ApotekaApp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Table(name="korisnici")
@Inheritance(strategy=SINGLE_TABLE)
@SequenceGenerator(name="korisnik_generator",initialValue = 3 ,sequenceName = "korisnik_seq")
@DiscriminatorColumn(name="type", discriminatorType=STRING)
public class Korisnik implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "korisnik_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="email", unique=true, nullable=false)
    private String email;

    @Column(name="lozinka", unique=false, nullable=false)
    private String lozinka;

    @Column(name="ime", unique=false, nullable=false)
    private String ime;

    @Column(name="prezime", unique=false, nullable=false)
    private String prezime;

    @Column(name="adresa", unique=false, nullable=false)
    private String adresa;

    @Column(name="grad", unique=false, nullable=false)
    private String grad;

    @Column(name="drzava", unique=false, nullable=false)
    private String drzava;

    @Column(name="broj", unique=false, nullable=false)
    private String broj;

    @Column
    private boolean pretplacen;

    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authorities_korsinik",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    @OneToOne(targetEntity = VerificationToken.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, name = "token_id")
    private VerificationToken token;

    public Korisnik(){}

    public Korisnik(Long id, String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, boolean pretplacen) {
        this.id = id;
        this.email = email;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
        this.pretplacen = pretplacen;
    }

    public Korisnik(Long id, String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, boolean pretplacen, boolean enabled) {
        this.id = id;
        this.email = email;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
        this.pretplacen = pretplacen;
        this.enabled = enabled;
    }

    public Korisnik(Long id, String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, boolean pretplacen, boolean enabled, List<Authority> authorities, VerificationToken token) {
        this.id = id;
        this.email = email;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
        this.pretplacen = pretplacen;
        this.enabled = enabled;
        this.authorities = authorities;
        this.token = token;
    }

    public Korisnik(String email, String lozinka, String ime, String prezime, String adresa, String grad, String drzava, String broj, boolean pretplacen, boolean enabled, List<Authority> authorities, VerificationToken token) {
        this.email = email;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.broj = broj;
        this.pretplacen = pretplacen;
        this.enabled = enabled;
        this.authorities = authorities;
        this.token = token;
    }

    public boolean isPretplacen() {
        return pretplacen;
    }

    public void setPretplacen(boolean pretplacen) {
        this.pretplacen = pretplacen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.lozinka;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public VerificationToken getToken() {
        return token;
    }

    public void setToken(VerificationToken token) {
        this.token = token;
    }
}
