package com.hoangfvi.luyentap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T> {
    T save(T t);
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void remove(Long id);

}
