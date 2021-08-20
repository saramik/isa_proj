package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByEmail(String email);
}
