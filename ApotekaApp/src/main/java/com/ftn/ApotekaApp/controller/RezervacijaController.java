package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.PregledDTO;
import com.ftn.ApotekaApp.dto.RezervacijaDTO;
import com.ftn.ApotekaApp.helper.PregledMapper;
import com.ftn.ApotekaApp.helper.RezervacijaMapper;
import com.ftn.ApotekaApp.model.*;
import com.ftn.ApotekaApp.service.LekDostupnostService;
import com.ftn.ApotekaApp.service.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drugbookings")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

    @Autowired
    private LekDostupnostService lekDostupnostService;

    private RezervacijaMapper rezervacijaMapper;

    public RezervacijaController() {
        this.rezervacijaMapper = new RezervacijaMapper();
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @GetMapping("")
    public ResponseEntity<?> getHistory() {
        Pacijent userDetails = (Pacijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<Rezervacija> rezervacije = rezervacijaService.findAllByPacijent(userDetails);
            return new ResponseEntity<>(getDTOList(rezervacije), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable("bookingId") Long bookingId) {
        Pacijent userDetails = (Pacijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            Rezervacija rezervacija = rezervacijaService.findOne(bookingId);

            LocalDateTime localdatum = LocalDateTime.of(rezervacija.getDatum(), LocalTime.MIDNIGHT);
            ZonedDateTime datum = ZonedDateTime.of(localdatum, ZoneId.of("Europe/Berlin"));
            Instant now = Instant.now();
            if ( !now.isBefore( datum.toInstant().minus( 24 , ChronoUnit.HOURS) ) || rezervacija.isPreuzeto())
                return new ResponseEntity<>("Ne moze se otkazati!", HttpStatus.NOT_FOUND);

            for (Lek lek : rezervacija.getLekovi()) {
                LekDostupnost lekDostupnost = lekDostupnostService.findByApotekaAndLek(rezervacija.getApoteka(), lek);
                lekDostupnost.setKolicina(lekDostupnost.getKolicina() + 1);
                lekDostupnostService.update(lekDostupnost, lekDostupnost.getId());
            }
            rezervacijaService.delete(bookingId);
            return new ResponseEntity<>("Uspesno otkazano!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private List<RezervacijaDTO> getDTOList(List<Rezervacija> apoteke) {
        List<RezervacijaDTO> list = new ArrayList<>();
        for(Rezervacija rezervacija: apoteke)
            list.add(rezervacijaMapper.toDto(rezervacija));
        return list;
    }

}
