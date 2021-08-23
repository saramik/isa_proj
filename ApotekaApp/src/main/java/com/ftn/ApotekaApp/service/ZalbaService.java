package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.Zalba;
import com.ftn.ApotekaApp.repository.ZalbaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZalbaService implements ServiceInterface<Zalba>{

    @Autowired
    private ZalbaRepository repository;

    @Override
    public List<Zalba> findAll() {
        return null;
    }

    @Override
    public Zalba findOne(Long id) {
        return null;
    }

    @Override
    public Zalba create(Zalba entity) throws Exception {
        return repository.save(entity);
    }

    @Override
    public Zalba update(Zalba entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
