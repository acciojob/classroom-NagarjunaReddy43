package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String studentName,String teacherName){
        studentRepository.addStudentTeacherPair(studentName,teacherName);
    }

    public Student getStudentByName(String studentname){
        return studentRepository.getStudentByName(studentname);
    }

    public Teacher getTeacherByName(String teacherName){
        return studentRepository.getTeacherByName(teacherName);
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        return studentRepository.getStudentsByTeacherName(teacherName);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacherName){
        studentRepository.deleteTeacher(teacherName);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
