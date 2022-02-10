package com.example.getdatabase.Repository;

import com.example.getdatabase.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Database extends JpaRepository<Student,String> {
    Student findByName(String name);
}
