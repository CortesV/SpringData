package com.mybookingpal.com.cache.redis.cache.service;

import com.mybookingpal.com.cache.redis.cache.interfaces.IStudent;
import com.mybookingpal.com.cache.redis.cache.interfaces.StudentRepository;
import com.mybookingpal.com.cache.redis.cache.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentRepositoryService {

    @Autowired
    private StringRedisConnection stringRedisConnection;

    @Autowired
    private ObjectHashMapper objectHashMapper;

    @Autowired
    private HashMapper<Object, byte[], byte[]> mapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private IStudent iStudent;

    public Student manipulateHashAndReadItBack(){
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        Map<String, String> rawHash = mapper.toHash(student).entrySet().stream().collect(Collectors.toMap(e -> new String(e.getKey()), e -> new String(e.getValue())));
        System.out.println(rawHash);
        stringRedisConnection.hMSet("student:1", rawHash);
        stringRedisConnection.hSet("student:1", "name", "grade");
        Student fromHash = (Student) mapper.fromHash(stringRedisConnection.hGetAll("student:1".getBytes()));
        return fromHash;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        iStudent.updateStudent(student);
    }

    public Student findStudent(String id) {
        return studentRepository.findOne(id);
    }

    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(String id) {
        studentRepository.delete(id);
    }

    public List<Student> findAllStudents(String name, Integer grade) {
        return studentRepository.findByNameAndGrade(name, grade);
    }
}
