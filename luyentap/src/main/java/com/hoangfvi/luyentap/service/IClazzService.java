package com.hoangfvi.luyentap.service;

import com.hoangfvi.luyentap.model.Clazz;

import java.util.Optional;

public interface IClazzService extends IService <Clazz>{
    Iterable<Clazz> findAll();

}
