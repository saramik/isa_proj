package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.UserDTO;
import com.ftn.ApotekaApp.event.OnRegistrationCompleteEvent;
import com.ftn.ApotekaApp.model.Korisnik;
import com.ftn.ApotekaApp.model.Zalba;
import com.ftn.ApotekaApp.service.ZalbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/complaints")
public class ZalbaController {

    @Autowired
    private ZalbaService zalbaService;

    @PostMapping("")
    public ResponseEntity<?> createComplaint(@RequestBody Zalba zalba) throws Exception {
        try {
            Zalba zalbacr = zalbaService.create(zalba);
            return new ResponseEntity<>(zalbacr, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
    }
}
