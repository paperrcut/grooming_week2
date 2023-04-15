package com.practice.week2.FileHandling;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student {

    private  String name;
    private String roll;
    private List<Double> grades = new ArrayList<>();
    private double averageGrade;

    public Student(String name, String roll) {
        this.name = name;
        this.roll = roll;
        this.averageGrade = 0.0;
    }

    public void addGrade(double grade)
    {
        grades.add(grade);
    }

    public void calculateAverageGrade()
    {
        double total =0.0;
        for (double grade:grades) {
            total+=grade;
        }
        averageGrade=total/grades.size();
    }

    @Override
    public String toString() {
        return "Roll: "+roll+"\tName: "+name+"\tAvgGrade: "+averageGrade+"\n";
    }
}
