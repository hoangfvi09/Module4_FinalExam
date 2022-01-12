package com.hoangfvi.luyentap.controller;

import com.hoangfvi.luyentap.model.Country;
import com.hoangfvi.luyentap.service.ICountryService;
import com.hoangfvi.luyentap.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private ICityService studentService;

    @Autowired
    private ICountryService clazzService;

    @GetMapping
    public ResponseEntity<Iterable<Country>> findAll() {
        Iterable<Country> classes =clazzService.findAll();
        if(classes==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

}
