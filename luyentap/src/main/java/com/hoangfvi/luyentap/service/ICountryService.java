package com.hoangfvi.luyentap.service;

import com.hoangfvi.luyentap.model.Country;

public interface ICountryService extends IService <Country>{
    Iterable<Country> findAll();

}
