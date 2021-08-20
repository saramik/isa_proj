package com.ftn.ApotekaApp.helper;

import com.ftn.ApotekaApp.dto.ApotekaDTO;
import com.ftn.ApotekaApp.dto.PregledDTO;
import com.ftn.ApotekaApp.model.Apoteka;
import com.ftn.ApotekaApp.model.Pregled;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;

public class PregledMapper implements MapperInterface<Pregled, PregledDTO>{
    @Override
    public Pregled toEntity(PregledDTO dto) {
        return null;
    }

    @Override
    public PregledDTO toDto(Pregled entity) {
        return new PregledDTO(entity.getId(), entity.getTipPregleda().getTip().toString(), entity.getDatum().atStartOfDay(ZoneId.of("Europe/Berlin")).toInstant().toEpochMilli() + "",
                entity.getTermin().getPocetakTermina().get(ChronoField.MILLI_OF_DAY) + "", entity.getTermin().getKrajTermina().get(ChronoField.MILLI_OF_DAY) + "", entity.getStrucnoLice().getIme() + " " + entity.getStrucnoLice().getPrezime());
    }
}
