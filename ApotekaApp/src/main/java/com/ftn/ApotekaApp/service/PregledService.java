package com.ftn.ApotekaApp.service;

import com.ftn.ApotekaApp.model.Lek;
import com.ftn.ApotekaApp.model.Pacijent;
import com.ftn.ApotekaApp.model.Pregled;
import com.ftn.ApotekaApp.repository.PregledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PregledService implements ServiceInterface<Pregled>{

    @Autowired
    private PregledRepository pregledRepository;

    @Override
    public List<Pregled> findAll() {
        return pregledRepository.findAll();
    }

    @Override
    public Pregled findOne(Long id) {
        return pregledRepository.findById(id).orElseGet(null);
    }


    public List<Pregled> findHistory(boolean izvrsen, Pacijent pacijent) {
        return pregledRepository.findAllByIzvrsenAndPacijent(izvrsen, pacijent);
    }

    @Override
    public Pregled create(Pregled entity) throws Exception {
        return null;
    }

    @Override
    public Pregled update(Pregled entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        pregledRepository.deleteById(id);
    }
}
