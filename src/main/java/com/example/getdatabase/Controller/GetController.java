package com.example.getdatabase.Controller;


import com.example.getdatabase.Entity.Student;
import com.example.getdatabase.Repository.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetController {
    @Autowired
    Database database;
    @GetMapping( "/")
    public List<Student> getId(){
        List<Student> stud=  database.findAll();
        return stud;
    }
    @PutMapping("/{student_id}")
    public Student Modify(@PathVariable("student_id") String student_id, @RequestBody Student stud)
    {
        Student object=new Student();
             Student stid=database.getById(student_id);
             stid.setName(stud.getName());
             database.save(stid);
             return stid;
    }
    @DeleteMapping("/{student_id}")
    public String removedetails


            (@PathVariable("student_id") String student_id)
    {

        database.deleteById(student_id);
        return "deleted successfully";


        
    }
    @GetMapping("/getname/{name}")
    public Student findName(@PathVariable("name") String name){
        Student student= (Student) database.findByName(name);
        return student;
    }
    @PostMapping("/")
    public String addStudent(@RequestBody Student student){
        database.save(student);
        return "posted successfully";
    }
}



