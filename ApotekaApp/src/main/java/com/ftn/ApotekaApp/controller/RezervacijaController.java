package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.PregledDTO;
import com.ftn.ApotekaApp.dto.RezervacijaDTO;
import com.ftn.ApotekaApp.helper.PregledMapper;
import com.ftn.ApotekaApp.helper.RezervacijaMapper;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Rezervacija;
import com.ftn.ApotekaApp.service.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drugbookings")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

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

    private List<RezervacijaDTO> getDTOList(List<Rezervacija> apoteke) {
        List<RezervacijaDTO> list = new ArrayList<>();
        for(Rezervacija rezervacija: apoteke)
            list.add(rezervacijaMapper.toDto(rezervacija));
        return list;
    }

}
