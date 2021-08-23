package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EReceptRepository extends JpaRepository<ERecept, Long> {

    List<ERecept> findAllByPacijent(Pacijent pacijent);

    List<ERecept> findAllByStatus(StatusERecept statusERecept);
}
