package com.mybookingpal.com.cache.redis.cache.interfaces;

import com.mybookingpal.com.cache.redis.cache.model.Student;

import java.util.Map;

public interface IStudent {

    public void saveStudent(Student person);
    public void updateStudent(Student student);
    public Student findStudent(String id);
    public Map<Object, Object> findAllStudents();
    public void deleteStudent(String id);
}
