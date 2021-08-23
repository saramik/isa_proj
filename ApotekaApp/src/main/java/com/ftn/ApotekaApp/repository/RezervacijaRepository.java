package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

    List<Rezervacija> findAllByPacijent(Pacijent pacijent);
}
