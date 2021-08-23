package com.ftn.ApotekaApp.helper;

import com.ftn.ApotekaApp.dto.LekDTO;
import com.ftn.ApotekaApp.dto.UserDTO;
import com.ftn.ApotekaApp.model.Korisnik;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.model.Pacijent;

import java.util.ArrayList;
import java.util.List;

public class PacijentMapper implements MapperInterface<Pacijent, UserDTO>{
    @Override
    public Pacijent toEntity(UserDTO dto) {
        return new Pacijent(dto.getEmail(), dto.getPassword(), dto.getIme(), dto.getPrezime(), dto.getAdresa(), dto.getGrad(), dto.getDrzava(), dto.getBroj());
    }

    public Pacijent toEntityUpdate(UserDTO dto, ArrayList<Lek> lekovi) {
        return new Pacijent(dto.getEmail(), dto.getPassword(), dto.getIme(), dto.getPrezime(), dto.getAdresa(), dto.getGrad(), dto.getDrzava(), dto.getBroj(), lekovi);
    }

    @Override
    public UserDTO toDto(Pacijent entity) {
        List<LekDTO> lekovi = new ArrayList<>();
        for (Lek lek : entity.getAlergijaLekovi())
            lekovi.add(new LekDTO(lek.getId(),lek.getNaziv(), lek.getSifra()));
        return new UserDTO(entity.getEmail(), null, entity.getIme(), entity.getPrezime(), entity.getAdresa(), entity.getGrad(), entity.getDrzava(), entity.getBroj(), lekovi, entity.getPenali());
    }
}
