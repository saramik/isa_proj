package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Savetovanje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavetovanjeRepository extends JpaRepository<Savetovanje, Long> {

    List<Savetovanje> findByIzvrsenAndPacijent(boolean izvrsen, Pacijent pacijent);
}
