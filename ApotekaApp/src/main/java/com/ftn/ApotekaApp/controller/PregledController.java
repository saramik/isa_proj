package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.ApotekaDTO;
import com.ftn.ApotekaApp.dto.PregledDTO;
import com.ftn.ApotekaApp.helper.ApotekaMapper;
import com.ftn.ApotekaApp.helper.PregledMapper;
import com.ftn.ApotekaApp.model.Apoteka;
import com.ftn.ApotekaApp.model.Korisnik;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.service.PregledService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/examinations")
public class PregledController {

    @Autowired
    private PregledService pregledService;

    private PregledMapper pregledMapper;

    public PregledController() {
        this.pregledMapper = new PregledMapper();
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @GetMapping("/history")
    public ResponseEntity<?> getHistory() {
        Pacijent userDetails = (Pacijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<Pregled> pregledi = pregledService.findHistory(true, userDetails);
            //Hibernate.initialize(userDetails.getPregledi());
            //List<Pregled> pregledi = userDetails.getPregledi().stream().filter(Pregled::getIzvrsen).collect(Collectors.toList());
            //List<Pregled> pregledi = pregledService.findAll();
            return new ResponseEntity<>(getDTOList(pregledi), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @GetMapping("/appointments")
    public ResponseEntity<?> getAppointments() {
        Pacijent userDetails = (Pacijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<Pregled> pregledi = pregledService.findHistory(false, userDetails);
            return new ResponseEntity<>(getDTOList(pregledi), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private List<PregledDTO> getDTOList(List<Pregled> apoteke) {
        List<PregledDTO> list = new ArrayList<>();
        for(Pregled pregled: apoteke)
            list.add(pregledMapper.toDto(pregled));
        return list;
    }

}
