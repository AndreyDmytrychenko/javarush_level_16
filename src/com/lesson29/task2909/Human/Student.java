package com.lesson29.task2909.Human;


import java.util.Date;

public class Student extends UniversityPerson {
    private int numberOfStudents;
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;


    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }
    public int getCourse() {
        return course;
    }

    public void live() {
        learn();
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {

        setAverageGrade(getAverageGrade() + delta);
    }



    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setCourse(int course) {
        this.course = course;
    }



    public void setBeginningOfSession(Date beginning) {
        beginningOfSession = beginning;
    }

    public void setEndOfSession(Date end) {
        endOfSession = end;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}
