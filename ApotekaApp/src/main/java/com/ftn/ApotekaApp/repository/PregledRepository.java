package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.Authority;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PregledRepository extends JpaRepository<Pregled, Long> {

    List<Pregled> findAllByIzvrsenAndPacijent(boolean izvrsen, Pacijent pacijent);
}
