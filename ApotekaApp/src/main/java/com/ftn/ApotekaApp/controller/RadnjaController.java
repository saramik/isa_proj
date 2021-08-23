package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.model.OpstaRadnja;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Radnja;
import com.ftn.ApotekaApp.service.RadnjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/medicalservices")
public class RadnjaController {

    @Autowired
    private RadnjaService radnjaService;

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable("appointmentId") Long appointmentId) {
        Pacijent userDetails = (Pacijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            Radnja radnja = radnjaService.findOne(appointmentId);

            if (radnja instanceof OpstaRadnja)
                return new ResponseEntity<>("Ne moze se otkazati!", HttpStatus.NOT_FOUND);

            LocalDateTime localdatum = LocalDateTime.of(radnja.getDatum(),radnja.getTermin().getPocetakTermina());
            ZonedDateTime datum = ZonedDateTime.of(localdatum, ZoneId.of("Europe/Berlin"));
            Instant now = Instant.now();
            if ( !now.isBefore( datum.toInstant().minus( 24 , ChronoUnit.HOURS) ) || radnja.getIzvestaj() != null)
                return new ResponseEntity<>("Ne moze se otkazati!", HttpStatus.NOT_FOUND);

            radnjaService.delete(appointmentId);

            return new ResponseEntity<>("Uspesno otkazano!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
