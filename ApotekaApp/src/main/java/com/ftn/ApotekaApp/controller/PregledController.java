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
@RequestMapping("/examinations")
public class PregledController {

    @Autowired
    private PregledService pregledService;

    private PregledMapper pregledMapper;

    public PregledController() {
        this.pregledMapper = new PregledMapper();
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @GetMapping()
    public ResponseEntity<?> getHistory() {
        Korisnik userDetails = (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<Pregled> pregledi = pregledService.findHistory((Pacijent) userDetails);
            //List<Pregled> pregledi = pregledService.findAll();
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
