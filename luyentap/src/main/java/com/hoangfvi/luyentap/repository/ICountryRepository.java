package com.hoangfvi.luyentap.repository;


import com.hoangfvi.luyentap.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends CrudRepository <Country,Long> {
}
