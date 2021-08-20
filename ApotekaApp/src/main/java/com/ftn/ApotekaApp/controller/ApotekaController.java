package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.ApotekaDTO;
import com.ftn.ApotekaApp.helper.ApotekaMapper;
import com.ftn.ApotekaApp.model.Apoteka;
import com.ftn.ApotekaApp.service.ApotekaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pharmacies")
public class ApotekaController {

    @Autowired
    private ApotekaService apotekaService;

    private ApotekaMapper apotekaMapper;

    public ApotekaController() {
        this.apotekaMapper = new ApotekaMapper();
    }

    @GetMapping()
    public ResponseEntity<?> getPharmacies() {
        try {
            List<Apoteka> apoteke = apotekaService.findAll();
            return new ResponseEntity<>(getDTOList(apoteke), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private List<ApotekaDTO> getDTOList(List<Apoteka> apoteke) {
        List<ApotekaDTO> list = new ArrayList<ApotekaDTO>();
        for(Apoteka apoteka: apoteke)
            list.add(apotekaMapper.toDto(apoteka));
        return list;
    }

}
