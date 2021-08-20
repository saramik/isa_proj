package com.ftn.ApotekaApp.helper;

import com.ftn.ApotekaApp.dto.ApotekaDTO;
import com.ftn.ApotekaApp.dto.UserDTO;
import com.ftn.ApotekaApp.model.Apoteka;
import com.ftn.ApotekaApp.model.Pacijent;

public class ApotekaMapper  implements MapperInterface<Apoteka, ApotekaDTO>{
    @Override
    public Apoteka toEntity(ApotekaDTO dto) {
        return null;
    }

    @Override
    public ApotekaDTO toDto(Apoteka entity) {
        return new ApotekaDTO(entity.getId(), entity.getNaziv(), entity.getGrad(), entity.getAdresa());
    }
}
