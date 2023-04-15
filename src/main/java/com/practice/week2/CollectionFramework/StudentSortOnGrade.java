package com.practice.week2.CollectionFramework;

import java.util.Comparator;

public class StudentSortOnGrade implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAverageGrade()==o2.getAverageGrade()) {
            //return new StudentSortOnName().compare(o1, o2);
            return 0;
        }
        else
            return (o1.getAverageGrade()>o2.getAverageGrade()?1:-1);
    }
}
