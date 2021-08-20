package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.Apoteka;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.repository.ApotekaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApotekaService implements ServiceInterface<Apoteka>{

    @Autowired
    private ApotekaRepository repository;

    @Override
    public List<Apoteka> findAll() {
        return repository.findAll();
    }

    @Override
    public Apoteka findOne(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public Apoteka create(Apoteka entity) throws Exception {
        return null;
    }

    @Override
    public Apoteka update(Apoteka entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
