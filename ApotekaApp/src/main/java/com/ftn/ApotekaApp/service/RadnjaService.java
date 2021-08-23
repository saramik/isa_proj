package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Radnja;
import com.ftn.ApotekaApp.repository.RadnjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RadnjaService implements ServiceInterface<Radnja>{

    @Autowired
    private RadnjaRepository repository;

    @Override
    public List<Radnja> findAll() {
        return null;
    }

    @Override
    public Radnja findOne(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public Radnja create(Radnja entity) throws Exception {
        return null;
    }

    @Override
    public Radnja update(Radnja entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        repository.deleteById(id);
    }
}
