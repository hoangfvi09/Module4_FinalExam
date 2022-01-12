package com.hoangfvi.luyentap.controller;

import com.hoangfvi.luyentap.model.City;
import com.hoangfvi.luyentap.model.Country;
import com.hoangfvi.luyentap.service.ICountryService;
import com.hoangfvi.luyentap.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("cityList")
    public Iterable<Country> classList() {
        return countryService.findAll();
    }

    @GetMapping
    public ResponseEntity<Iterable<City>> findAll() {
        Iterable<City> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> createStudent(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){
        Optional <City> cityOptional = cityService.findById(id);
        if(!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        City city = cityOptional.get();
        return new ResponseEntity<>(city,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@RequestBody City city, @PathVariable Long id){
        Optional <City> cityOptional = cityService.findById(id);
        if(!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        return new ResponseEntity<>(cityService.save(city),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id){
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



//
//    @GetMapping("/edit/{id}")
//    public String showEditForm(Model model, @PathVariable Long id) {
//        model.addAttribute("student", cityService.findById(id).get());
//        return "student/edit";
//    }
//
//    @PostMapping("/edit")
//    public String edit(City city) {
//        cityService.save(city);
//        return "redirect:/find";
//
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<Page<City>> search(@RequestParam String q, Pageable pageable){
//        Page<City> students = cityService.findAllByNameContaining(pageable,q);
//        if(students.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(students, HttpStatus.OK);
//
//    }
//    @GetMapping("/country/{id}")
//    public ResponseEntity<Iterable<City>> findByCountry( @PathVariable Long id){
//        Iterable<City> cities = cityService.findAllByClassId(id);
//
//        return new ResponseEntity<>(cities, HttpStatus.OK);
//
//    }


}
