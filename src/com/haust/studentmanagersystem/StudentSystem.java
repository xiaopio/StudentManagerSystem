package com.haust.studentmanagersystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem extends StudentManagementImpl {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        IStudentManager studentManager = new StudentManagementImpl();

        while (true) {
            System.out.println("----------欢迎使用学生管理系统----------");
            System.out.println("----------1.添加学生\t" + "2.删除学生---------");
            System.out.println("----------3.修改学生\t" + "4.查询学生---------");
            System.out.println("--------------0.退出系统---------------");
            System.out.println("请输入您的选择：\t");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            switch (choose) {
                case "1":
                    Student student = addStudentInfo();
                    studentManager.addStudent(list, student);
                    break;
                case "2":
                    studentManager.deleteStudent(list);
                    break;
                case "3":
                    studentManager.updateStudent(list);
                    break;
                case "4":
                    studentManager.queryStudent(list);
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("非法数字！！！");
                    break;
            }
        }


    }


}
