package com.haust.studentmanagersystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementImpl extends Student implements IStudentManager {
    Scanner sc = new Scanner(System.in);
    // 定义学生id
    String id;

    // 添加学生对象
    public static Student addStudentInfo() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("请输入学生id：");
        student.setId(sc.next());
        System.out.println("请输入学生姓名：");
        student.setName(sc.next());
        System.out.println("请输入学生年龄：");
        student.setAge(sc.nextInt());
        System.out.println("请输入学生家庭住址：");
        student.setAddress(sc.next());
        return student;

    }

    public boolean checkStuId(ArrayList<Student> list, Student student) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(student.getId())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addStudent(ArrayList<Student> list, Student student) {
        boolean result = checkStuId(list, student);
        if (result) {
            list.add(student);
            System.out.println("添加成功");
        } else {
            System.out.println("学生id已存在！！！");
        }
    }

    @Override
    public void updateStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("系统中没有学生信息！！！");
        } else {
            System.out.println("请输入学生id：");
            id = sc.next();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    loop:
                    while (true) {
                        System.out.println(list.get(i).toString());
                        System.out.println("1.修改学生姓名\t" + "2.修改学生年龄\n" + "3.修改学生家庭住址\t" + "0.退出");
                        System.out.println("请输入您的选择：");
                        String chose = sc.next();
                        switch (chose) {
                            case "1":
                                System.out.println("请输入修改后的姓名：");
                                list.get(i).setName(sc.next());
                                System.out.println("修改成功！！！");
                                break;
                            case "2":
                                System.out.println("请输入修改后的年龄：");
                                list.get(i).setAge(sc.nextInt());
                                System.out.println("修改成功！！！");
                                break;
                            case "3":
                                System.out.println("请输入修改后的家庭住址：");
                                list.get(i).setAddress(sc.next());
                                System.out.println("修改成功！！！");
                                break;
                            case "0":
                                break loop;
                            default:
                                System.out.println("参数错误，请重新输入！！！");
                                break;
                        }
                    }
                } else {
                    System.out.println("未找到学号为：" + id + "的学生信息，请核查！！！");
                }
            }
        }
    }

    @Override
    public void queryStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("系统中没有学生信息！！！");
        } else {
            loop:
            while (true) {
                System.out.println("1.查询所有学生信息\t" + "2.查询某位学生信息\n" + "0.退出");
                String choose = sc.next();
                switch (choose) {
                    case "1":
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i).toString());
                        }
                        break;
                    case "2":
                        System.out.println("请输入学生id：");
                        id = sc.next();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getId().equals(id)) {
                                System.out.println(list.get(i).toString());
                            } else {
                                System.out.println("未找到学号为：" + id + "的学生信息，请核查！！！");
                            }
                        }
                        break;
                    case "0":
                        break loop;
                    default:
                        System.out.println("参数错误，请重新输入！！！");
                }
            }
        }


    }

    @Override
    public void deleteStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("系统中没有学生信息！！！");
        } else {
            System.out.println("请输入要删除的学生id：");
            id = sc.next();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    System.out.println("查找到学号为：" + id + "的学生，学生信息如下：");
                    System.out.println(list.get(i).toString());
                    System.out.println("确认要删除该学生信息？？？");
                    System.out.println("  1.确认    0.取消");
                    String confirm = sc.next();
                    switch (confirm) {
                        case "1":
                            list.remove(i);
                            System.out.println("删除成功！！！");
                            break;
                        case "0":
                            System.out.println("取消操作！！！");
                            break;
                        default:
                            System.out.println("非法参数，请重新输入！！！");
                            break;
                    }
                } else {
                    System.out.println("未找到学号为：" + id + "的学生信息，请核查！！！");
                }
            }
        }
    }

}
