package com.hoangfvi.luyentap.service;


import com.hoangfvi.luyentap.model.Country;
import com.hoangfvi.luyentap.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CountryService implements ICountryService {

    @Autowired
    private ICountryRepository clazzRepository;


    @Override
    public Iterable<Country> findAll() {
        return clazzRepository.findAll();
    }

    @Override
    public Country save(Country country) {
        return null;
    }


    @Override
    public Optional<Country> findById(Long id) {
        return clazzRepository.findById(id);
    }

    @Override
    public void remove(Long id) {

    }



}
