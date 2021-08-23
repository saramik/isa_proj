package com.ftn.ApotekaApp.helper;

import com.ftn.ApotekaApp.dto.EReceptDTO;
import com.ftn.ApotekaApp.dto.LekDTO;
import com.ftn.ApotekaApp.model.ERecept;
import com.ftn.ApotekaApp.model.Lek;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class EReceptMapper implements MapperInterface<ERecept, EReceptDTO>{
    @Override
    public ERecept toEntity(EReceptDTO dto) {
        return null;
    }

    @Override
    public EReceptDTO toDto(ERecept entity) {
        List<LekDTO> lekovi = new ArrayList<>();
        for (Lek lek : entity.getLekovi())
            lekovi.add(new LekDTO(lek.getId(),lek.getNaziv(), lek.getSifra()));
        return new EReceptDTO(entity.getId(), entity.getDatumIzdavanja().atStartOfDay(ZoneId.of("Europe/Berlin")).toInstant().toEpochMilli() + "", entity.getStatus().toString(), lekovi);
    }
}
