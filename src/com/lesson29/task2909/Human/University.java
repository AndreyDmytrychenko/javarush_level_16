package com.lesson29.task2909.Human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students;
    protected String name;
    protected int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {


        return students
                .stream()
                .filter(s -> s.getAverageGrade() == averageGrade)
                .findFirst()
                .get();
    }

    public Student getStudentWithMaxAverageGrade() {

        return students
                .stream()
                .max( (s1, s2) -> Double.compare(s1.getAverageGrade(),s2.getAverageGrade()))
                .get();
    }

    public Student getStudentWithMinAverageGrade() {
        return students
                .stream()
                .min( (s1, s2) -> Double.compare(s1.getAverageGrade(),s2.getAverageGrade()))
                .get();
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
