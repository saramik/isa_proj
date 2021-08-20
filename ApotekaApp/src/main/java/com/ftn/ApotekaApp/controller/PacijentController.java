package com.ftn.ApotekaApp.controller;

import com.ftn.ApotekaApp.dto.LekDTO;
import com.ftn.ApotekaApp.dto.UserDTO;
import com.ftn.ApotekaApp.helper.PacijentMapper;
import com.ftn.ApotekaApp.model.Korisnik;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.service.KorisnikService;
import com.ftn.ApotekaApp.service.LekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/patients")
public class PacijentController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private LekService lekService;

    private PacijentMapper pacijentMapper;

    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable("userId") Long userId) {
        Korisnik user = korisnikService.findOne(userId);
        if ( user== null )
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        try
        {
            ArrayList<Lek> lekovi = new ArrayList<>();
            if(userDTO.getAlergijeLekovi().size() != 0){
                for (LekDTO lek : userDTO.getAlergijeLekovi()){
                    lekovi.add(lekService.findOne(lek.getId()));
                }
            }

            korisnikService.update(pacijentMapper.toEntityUpdate(userDTO, lekovi), userId);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
}
