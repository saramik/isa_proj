package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.Apoteka;
import com.ftn.ApotekaApp.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApotekaRepository extends JpaRepository<Apoteka, Long> {
}
