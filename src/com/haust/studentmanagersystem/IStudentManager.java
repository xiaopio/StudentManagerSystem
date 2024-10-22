package com.haust.studentmanagersystem;

import java.util.ArrayList;

public abstract interface IStudentManager {
    void addStudent(ArrayList<Student> list, Student student);

    void deleteStudent(ArrayList<Student> list);

    void queryStudent(ArrayList<Student> list);

    void updateStudent(ArrayList<Student> list);
}
