package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.model.Savetovanje;
import com.ftn.ApotekaApp.repository.SavetovanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavetovanjeService implements ServiceInterface<Savetovanje>{

    @Autowired
    private SavetovanjeRepository repository;

    @Override
    public List<Savetovanje> findAll() {
        return null;
    }

    @Override
    public Savetovanje findOne(Long id) {
        return null;
    }

    public List<Savetovanje> findHistory(Pacijent pacijent) {
        return repository.findByIzvrsenAndPacijent(true, pacijent);
    }

    @Override
    public Savetovanje create(Savetovanje entity) throws Exception {
        return null;
    }

    @Override
    public Savetovanje update(Savetovanje entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
