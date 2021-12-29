package com.hoangfvi.luyentap.repository;


import com.hoangfvi.luyentap.model.Clazz;
import com.hoangfvi.luyentap.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository <Student, Long> {
    Page<Student> findAllByNameContaining(Pageable pageable, String name);
    Page<Student> findAllByScoreGreaterThan(Pageable pageable, Double score);
    Page<Student> findAllByClazz(Pageable pageable, Clazz clazz);


}
