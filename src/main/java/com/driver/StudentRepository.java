package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap;
    HashMap<String ,Teacher> teacherHashMap;
    HashMap<String, List<String>> studentTeacherHashMap;

    public StudentRepository(){
        this.studentHashMap = new HashMap<>();
        this.teacherHashMap = new HashMap<>();
        this.studentTeacherHashMap = new HashMap<>();
    }

    public void addStudent(Student student){
        if(!studentHashMap.containsKey(student.getName())) {
            studentHashMap.put(student.getName(), student);
        }
    }

    public void addTeacher(Teacher teacher){
        if(!teacherHashMap.containsKey(teacher.getName())){
            teacherHashMap.put(teacher.getName(),teacher);
        }

    }

    public void addStudentTeacherPair(String studentName,String teacherName){
        if(!studentHashMap.containsKey(studentName) || !teacherHashMap.containsKey(studentName)){
            return;
        }

        if(!studentTeacherHashMap.containsKey(teacherName)){
            studentTeacherHashMap.get(teacherName).add(studentName);
        }
        else{
            List<String > lst = new ArrayList<>();
            lst.add(studentName);
            studentTeacherHashMap.put(teacherName,lst);
        }
    }

    public  Student getStudentByName(String studentname){
        return studentHashMap.get(studentname);
    }

    public Teacher getTeacherByName(String teacherName){
        return teacherHashMap.get(teacherName);
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        return studentTeacherHashMap.get(teacherName);
    }
    public List<String> getAllStudents(){
        List<String> ans = new ArrayList<>();

        for(String name : studentHashMap.keySet()){
            ans.add(name);
        }

        return ans;
    }

    public void deleteTeacher(String teacherName){
        List<String> lst = studentTeacherHashMap.get(teacherName);

        for(String name : lst){
            if(studentHashMap.containsKey(name)){
                studentHashMap.remove(name);
            }
        }

        studentTeacherHashMap.remove(teacherName);

        if(teacherHashMap.containsKey(teacherName)){
            teacherHashMap.remove(teacherName);
        }
    }

    public void deleteAllTeachers(){
        for(String name : studentTeacherHashMap.keySet()){
            List<String> lst = studentTeacherHashMap.get(name);
            for(int i=0;i<lst.size();i++){
                if(studentHashMap.containsKey(lst.get(i))){
                    studentHashMap.remove(lst.get(i));
                }
            }

            teacherHashMap.remove(name);
        }
        for(String name : teacherHashMap.keySet()){
            teacherHashMap.remove(name);
        }
    }
}
