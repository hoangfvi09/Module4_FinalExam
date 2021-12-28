package com.hoangfvi.luyentap.service;


import com.hoangfvi.luyentap.model.Student;
import com.hoangfvi.luyentap.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Student save(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {

        pageable = PageRequest.of(0,10, Sort.by("score"));
        return studentRepository.findAll(pageable);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Student> findAllByNameContaining(Pageable pageable, String name) {
        return studentRepository.findAllByNameContaining(pageable, name);
    }

    @Override
    public Page<Student> findAllByScoreGreaterThan8(Pageable pageable, Double score) {
        return studentRepository.findAllByScoreGreaterThan(pageable, score);
    }
}
