package com.hoangfvi.luyentap.controller;

import com.hoangfvi.luyentap.model.Clazz;
import com.hoangfvi.luyentap.model.Student;
import com.hoangfvi.luyentap.service.IClazzService;
import com.hoangfvi.luyentap.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classes")
public class ClazzController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClazzService clazzService;

    @GetMapping
    public ResponseEntity<Iterable<Clazz>> findAll() {
        Iterable<Clazz> classes =clazzService.findAll();
        if(classes==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

}
