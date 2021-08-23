package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.Apoteka;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.model.LekDostupnost;
import com.ftn.ApotekaApp.model.Radnja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LekDostupnostRepository extends JpaRepository<LekDostupnost, Long> {

    LekDostupnost findByApotekaAndLek(Apoteka apoteka, Lek lek);
}
