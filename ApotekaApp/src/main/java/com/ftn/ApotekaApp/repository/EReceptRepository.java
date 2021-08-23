package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.ERecept;
import com.ftn.ApotekaApp.model.Radnja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EReceptRepository extends JpaRepository<ERecept, Long> {
}
