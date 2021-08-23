package com.ftn.ApotekaApp.helper;

import com.ftn.ApotekaApp.dto.ApotekaDTO;
import com.ftn.ApotekaApp.dto.LekDTO;
import com.ftn.ApotekaApp.dto.PregledDTO;
import com.ftn.ApotekaApp.dto.RezervacijaDTO;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Rezervacija;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class RezervacijaMapper implements MapperInterface<Rezervacija, RezervacijaDTO>{
    @Override
    public Rezervacija toEntity(RezervacijaDTO dto) {
        return null;
    }

    @Override
    public RezervacijaDTO toDto(Rezervacija entity) {
        List<LekDTO> lekovi = new ArrayList<>();
        for (Lek lek : entity.getLekovi())
            lekovi.add(new LekDTO(lek.getId(),lek.getNaziv(), lek.getSifra()));
        return new RezervacijaDTO(entity.getId(), entity.getDatum().atStartOfDay(ZoneId.of("Europe/Berlin")).toInstant().toEpochMilli() + "", entity.isPreuzeto(),
                new ApotekaDTO(entity.getApoteka().getId(), entity.getApoteka().getNaziv(), entity.getApoteka().getGrad(), entity.getApoteka().getAdresa())
                ,lekovi);
    }
}
