package com.hoangfvi.luyentap.repository;


import com.hoangfvi.luyentap.model.City;
import com.hoangfvi.luyentap.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends CrudRepository<City, Long>  {



}
