package com.hoangfvi.luyentap.service;


import com.hoangfvi.luyentap.model.City;
import com.hoangfvi.luyentap.repository.ICountryRepository;
import com.hoangfvi.luyentap.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CityService implements ICityService {

    @Autowired
    private ICityRepository studentRepository;

    @Autowired
    private ICountryRepository clazzRepository;

    @Override
    public City save(City city) {
       return studentRepository.save(city);
    }

    @Override
    public Iterable<City> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);

    }




}
