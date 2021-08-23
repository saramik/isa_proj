package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Rezervacija;
import com.ftn.ApotekaApp.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezervacijaService implements ServiceInterface<Rezervacija>{

    @Autowired
    private RezervacijaRepository repository;

    @Override
    public List<Rezervacija> findAll() {
        return repository.findAll();
    }

    public List<Rezervacija> findAllByPacijent(Pacijent pacijent) {
        return repository.findAllByPacijent(pacijent);
    }

    @Override
    public Rezervacija findOne(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public Rezervacija create(Rezervacija entity) throws Exception {
        return null;
    }

    @Override
    public Rezervacija update(Rezervacija entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
