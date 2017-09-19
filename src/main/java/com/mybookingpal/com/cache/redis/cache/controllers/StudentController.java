package com.mybookingpal.com.cache.redis.cache.controllers;

import com.mybookingpal.com.cache.redis.cache.model.Student;
import com.mybookingpal.com.cache.redis.cache.service.StudentRepositoryService;
import com.mybookingpal.com.cache.redis.cache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepositoryService studentRepositoryService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Student findStudent(@PathVariable("id") String id) {
        Student student = new Student("Eng2015001", "John Snoy", Student.Gender.MALE, 1);
        studentService.updateStudent(student);
        Student student2 = new Student("Eng2015002", "John Morr", Student.Gender.MALE, 2);
        studentService.saveStudent(student2);
        return studentService.findStudent(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
    public Map<Object, Object> findAllStudents() {
        return studentService.findAllStudents();
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json")
    public void deleteStudent(String id) {
        studentService.deleteStudent(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public Student find() {
        return studentRepositoryService.manipulateHashAndReadItBack();
    }

    @RequestMapping(value = "data/", method = RequestMethod.POST, produces = "application/json")
    public void saveStudentData(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @RequestMapping(value = "data/", method = RequestMethod.PUT, produces = "application/json")
    public void updateStudentData(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @RequestMapping(value = "data/{id}", method = RequestMethod.GET, produces = "application/json")
    public Student findStudentData(@PathVariable("id") String id) {
        return studentService.findStudent(id);
    }

    @RequestMapping(value = "data/list", method = RequestMethod.GET, produces = "application/json")
    public Map<Object, Object> findAllStudentsData() {
        Student student = new Student("Eng2015004", "John Moriwwwwson", Student.Gender.MALE, 2);
        studentService.saveStudent(student);
        Student student2 = new Student("Eng2015003", "John KKK", Student.Gender.MALE, 2);
        studentService.updateStudent(student2);
        return studentService.findAllStudents();
    }

    @RequestMapping(value = "data/", method = RequestMethod.DELETE, produces = "application/json")
    public void deleteStudentData(String id) {
        studentService.deleteStudent(id);
    }
}
