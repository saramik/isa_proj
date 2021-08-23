package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.EReceptDTO;
import com.ftn.ApotekaApp.dto.LekFilterDTO;
import com.ftn.ApotekaApp.dto.PregledDTO;
import com.ftn.ApotekaApp.dto.UserLoginDTO;
import com.ftn.ApotekaApp.helper.EReceptMapper;
import com.ftn.ApotekaApp.helper.PregledMapper;
import com.ftn.ApotekaApp.model.ERecept;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.StatusERecept;
import com.ftn.ApotekaApp.service.EReceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/erecepts")
public class EReceptController {

    @Autowired
    private EReceptService eReceptService;

    private EReceptMapper eReceptMapper;

    public EReceptController() {
        this.eReceptMapper = new EReceptMapper();
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @GetMapping("/history")
    public ResponseEntity<?> getHistory() {
        Pacijent userDetails = (Pacijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<ERecept> erecepti = eReceptService.findAllByPacijent(userDetails);
            return new ResponseEntity<>(getDTOList(erecepti), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @PostMapping("/filter")
    public ResponseEntity<?> getHistory(@Valid @RequestBody LekFilterDTO lekFilterDTO) {
        Pacijent userDetails = (Pacijent) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            List<ERecept> erecepti = eReceptService.filterByStatus(StatusERecept.valueOf(lekFilterDTO.getStatus()));
            return new ResponseEntity<>(getDTOList(erecepti), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private List<EReceptDTO> getDTOList(List<ERecept> apoteke) {
        List<EReceptDTO> list = new ArrayList<>();
        for(ERecept eRecept: apoteke)
            list.add(eReceptMapper.toDto(eRecept));
        return list;
    }
}
