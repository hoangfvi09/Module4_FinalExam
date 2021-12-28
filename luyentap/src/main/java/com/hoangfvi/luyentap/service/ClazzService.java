package com.hoangfvi.luyentap.service;


import com.hoangfvi.luyentap.model.Clazz;
import com.hoangfvi.luyentap.repository.IClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ClazzService implements IClazzService {

    @Autowired
    private IClazzRepository clazzRepository;


    @Override
    public Iterable<Clazz> findAll() {
        return clazzRepository.findAll();
    }

    @Override
    public Clazz save(Clazz clazz) {
        return null;
    }

    @Override
    public Page<Clazz> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Clazz> findById(Long id) {
        return clazzRepository.findById(id);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Clazz> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }


}
