package com.practice.week2.Comparable_Comparator;

import java.util.Comparator;

public class EmployeeSortOnAge implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1 == o2)
            return 0;
        else {
            if(!(o1.getAge() == o2.getAge()))
            {
                return o1.getAge()-o2.getAge();
            }
            else {
                return o1.getSalary()-o2.getSalary();
            }
        }
    }
}
