package com.ftn.ApotekaApp.repository;

import com.ftn.ApotekaApp.model.VerificationToken;
import com.ftn.ApotekaApp.model.VerificationTokenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByTokenAndType(String token, VerificationTokenType type);

}
