package com.example.week3;

import android.graphics.Bitmap;

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

//    void updateStdImage(Bitmap img, Student tobeupdated){
//        tobeupdated.std_img = img;
//    }

    void saveNewStudent(String name, int yob, String college){
        list.add(new Student(name,yob,college));
    }
}


