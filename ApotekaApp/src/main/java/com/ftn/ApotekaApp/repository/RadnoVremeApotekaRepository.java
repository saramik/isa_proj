package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.Radnja;
import com.ftn.ApotekaApp.model.RadnoVremeApoteka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadnoVremeApotekaRepository extends JpaRepository<RadnoVremeApoteka, Long> {
}
