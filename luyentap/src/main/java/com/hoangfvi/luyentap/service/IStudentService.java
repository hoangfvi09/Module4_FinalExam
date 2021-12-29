package com.hoangfvi.luyentap.service;

import com.hoangfvi.luyentap.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IService <Student> {
    Page<Student> findAllByScoreGreaterThan8(Pageable pageable, Double score);
    public Page<Student> findAllByClassId(Pageable pageable,Long id);

}
