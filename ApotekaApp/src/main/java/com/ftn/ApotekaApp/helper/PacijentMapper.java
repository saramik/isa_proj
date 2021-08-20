package com.ftn.ApotekaApp.helper;

import com.ftn.ApotekaApp.dto.UserDTO;
import com.ftn.ApotekaApp.model.Korisnik;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.model.Pacijent;

import java.util.ArrayList;

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
        return null;
    }
}
