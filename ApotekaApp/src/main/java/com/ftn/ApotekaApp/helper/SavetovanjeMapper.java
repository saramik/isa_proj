package com.ftn.ApotekaApp.helper;

import com.ftn.ApotekaApp.dto.PregledDTO;
import com.ftn.ApotekaApp.dto.SavetovanjeDTO;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Savetovanje;

import java.time.ZoneId;
import java.time.temporal.ChronoField;

public class SavetovanjeMapper implements MapperInterface<Savetovanje, SavetovanjeDTO>{


    @Override
    public Savetovanje toEntity(SavetovanjeDTO dto) {
        return null;
    }

    @Override
    public SavetovanjeDTO toDto(Savetovanje entity) {
        return new SavetovanjeDTO(entity.getId(), entity.getDatum().atStartOfDay(ZoneId.of("Europe/Berlin")).toInstant().toEpochMilli() + "",
                entity.getTermin().getPocetakTermina().get(ChronoField.MILLI_OF_DAY) + "", entity.getTermin().getKrajTermina().get(ChronoField.MILLI_OF_DAY) + "", entity.getStrucnoLice().getIme() + " " + entity.getStrucnoLice().getPrezime());

    }
}
