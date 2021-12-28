package com.hoangfvi.luyentap.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double score;

    private int age;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz clazz;

    public Student(Long id, String name, Double score, int age, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
        this.clazz = clazz;
    }

    public Student(String name, Double score, int age, Clazz clazz) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.clazz = clazz;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
