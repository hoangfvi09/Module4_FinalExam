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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClazzService clazzService;

    @ModelAttribute("classList")
    public Iterable<Clazz> classList() {
        return clazzService.findAll();
    }

    @GetMapping
    public ResponseEntity<Page<Student>> findAll(Pageable pageable) {
        Page<Student> students = studentService.findAll(pageable);
        if(students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Optional <Student> studentOptional = studentService.findById(id);
        if(!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Student student = studentOptional.get();
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Long id){
        Optional <Student> studentOptional = studentService.findById(id);
        if(!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(studentOptional.get().getId());
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }












    @GetMapping("/list-greater-8")
    public ModelAndView findList8(Pageable pageable) {
        Page<Student> studentList;
        ModelAndView modelAndView = new ModelAndView("student/list");
        studentList = studentService.findAllByScoreGreaterThan8(pageable, 8.0);
        modelAndView.addObject("studentList", studentList);
        modelAndView.addObject("listName", "Students with score greater than 8");

        return modelAndView;
    }



    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.findById(id).get());
        return "student/edit";
    }

    @PostMapping("/edit")
    public String edit(Student student) {
        studentService.save(student);
        return "redirect:/find";

    }


}
