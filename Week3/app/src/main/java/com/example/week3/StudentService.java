package com.example.week3;

import java.util.ArrayList;

public class StudentService {
    public StudentService() {
        this.list = new ArrayList<Student>();
    }

    static StudentService shared = new StudentService();
    ArrayList<Student> list;

    void saveNewStudent(Student std){
        list.add(std);
    }

    void saveNewStudent(String name, int yob, String college){
        list.add(new Student(name,yob,college));
    }
}


