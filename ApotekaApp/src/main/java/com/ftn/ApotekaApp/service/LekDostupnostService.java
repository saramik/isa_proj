package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.Apoteka;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.model.LekDostupnost;
import com.ftn.ApotekaApp.repository.LekDostupnostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LekDostupnostService implements ServiceInterface<LekDostupnost>{

    @Autowired
    private LekDostupnostRepository repository;

    @Override
    public List<LekDostupnost> findAll() {
        return repository.findAll();
    }

    @Override
    public LekDostupnost findOne(Long id) {
        return null;
    }

    public LekDostupnost findByApotekaAndLek(Apoteka apoteka, Lek lek) {
        return repository.findByApotekaAndLek(apoteka, lek);
    }

    @Override
    public LekDostupnost create(LekDostupnost entity) throws Exception {
        return null;
    }

    @Override
    public LekDostupnost update(LekDostupnost entity, Long id) throws Exception {
        LekDostupnost lekDostupnost = repository.findById(id).orElseGet(null);
        lekDostupnost.setKolicina(entity.getKolicina());
        return repository.save(lekDostupnost);
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
