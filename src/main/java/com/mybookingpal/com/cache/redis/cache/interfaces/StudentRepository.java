package com.mybookingpal.com.cache.redis.cache.interfaces;

import com.mybookingpal.com.cache.redis.cache.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    public List<Student> findByNameAndGrade(String name, Integer grade);
}
