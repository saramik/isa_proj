package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Radnja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadnjaRepository extends JpaRepository<Radnja, Long> {
}
