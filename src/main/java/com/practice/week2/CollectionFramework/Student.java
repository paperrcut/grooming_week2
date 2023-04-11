package com.practice.week2.CollectionFramework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    public Student(String name, String roll) {
        this.name = name;
        this.roll = roll;
        this.averageGrade = 0.0;
    }

    private  String name;
    private String roll;
    private double averageGrade;

    @Override
    public boolean equals(Object o)
    {
        if(o==this)
            return true;
        if(!(o instanceof Student))
            return false;
        Student stud = (Student) o;
        return this.getRoll() == stud.getRoll();
    }

    @Override
    public String toString() {
        return "Roll: "+roll+"\tName: "+name+"\tAvgGrade: "+averageGrade+"\n";
    }
}
