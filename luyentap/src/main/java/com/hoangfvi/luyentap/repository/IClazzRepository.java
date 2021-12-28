package com.hoangfvi.luyentap.repository;


import com.hoangfvi.luyentap.model.Clazz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClazzRepository extends CrudRepository <Clazz,Long> {
}
