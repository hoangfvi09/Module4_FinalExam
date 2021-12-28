package com.hoangfvi.luyentap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T> {
    T save(T t);
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(Long id);
    void remove(Long id);
    Page<T> findAllByNameContaining(Pageable pageable, String name);
}
