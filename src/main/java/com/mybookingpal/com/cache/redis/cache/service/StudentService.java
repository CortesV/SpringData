package com.mybookingpal.com.cache.redis.cache.service;

import com.mybookingpal.com.cache.redis.cache.interfaces.IStudent;
import com.mybookingpal.com.cache.redis.cache.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private IStudent iStudent;

    public void saveStudent(Student student) {
        iStudent.saveStudent(student);
    }

    public void updateStudent(Student student) {
        iStudent.updateStudent(student);
    }

    public Student findStudent(String id) {
        return iStudent.findStudent(id);
    }

    public Map<Object, Object> findAllStudents() {
        return iStudent.findAllStudents();
    }

    public void deleteStudent(String id) {
        iStudent.deleteStudent(id);
    }
}
