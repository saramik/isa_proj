package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.PregledDTO;
import com.ftn.ApotekaApp.dto.SavetovanjeDTO;
import com.ftn.ApotekaApp.helper.PregledMapper;
import com.ftn.ApotekaApp.helper.SavetovanjeMapper;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Savetovanje;
import com.ftn.ApotekaApp.service.SavetovanjeService;
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
@RequestMapping("/consultations")
public class SavetovanjeController {

    @Autowired
    private SavetovanjeService savetovanjeService;

    private SavetovanjeMapper savetovanjeMapper;

    public SavetovanjeController() {
        this.savetovanjeMapper = new SavetovanjeMapper();
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @GetMapping()
    public ResponseEntity<?> getHistory() {
        Pacijent userDetails = (Pacijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<Savetovanje> savetovanja = savetovanjeService.findHistory(userDetails);
            //Hibernate.initialize(userDetails.getPregledi());
            //List<Pregled> pregledi = userDetails.getPregledi().stream().filter(Pregled::getIzvrsen).collect(Collectors.toList());
            //List<Pregled> pregledi = pregledService.findAll();
            return new ResponseEntity<>(getDTOList(savetovanja), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private List<SavetovanjeDTO> getDTOList(List<Savetovanje> apoteke) {
        List<SavetovanjeDTO> list = new ArrayList<>();
        for(Savetovanje savetovanje: apoteke)
            list.add(savetovanjeMapper.toDto(savetovanje));
        return list;
    }
}
