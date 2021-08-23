package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.ERecept;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Radnja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EReceptRepository extends JpaRepository<ERecept, Long> {

    List<ERecept> findByPacijent(Pacijent pacijent);
}
