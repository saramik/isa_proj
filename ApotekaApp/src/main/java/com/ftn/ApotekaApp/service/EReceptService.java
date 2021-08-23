package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.ERecept;
import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.repository.EReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EReceptService implements ServiceInterface<ERecept>{

    @Autowired
    private EReceptRepository repository;

    @Override
    public List<ERecept> findAll() {
        return repository.findAll();
    }

    public List<ERecept> findAllByPacijent(Pacijent pacijent) {
        return repository.findByPacijent(pacijent);
    }

    @Override
    public ERecept findOne(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public ERecept create(ERecept entity) throws Exception {
        return null;
    }

    @Override
    public ERecept update(ERecept entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
