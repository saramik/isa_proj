package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.repository.LekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LekService implements ServiceInterface<Lek>{

    @Autowired
    private LekRepository lekRepository;

    @Override
    public List<Lek> findAll() {
        return null;
    }

    @Override
    public Lek findOne(Long id) {
        return lekRepository.findById(id).orElseGet(null);
    }

    @Override
    public Lek create(Lek entity) throws Exception {
        return null;
    }

    @Override
    public Lek update(Lek entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
