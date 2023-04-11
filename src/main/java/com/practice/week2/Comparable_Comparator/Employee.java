package com.practice.week2.Comparable_Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;
    private int salary;

    @Override
    public String toString() {
        return "name: " + name  +
                "\tage: " + age +
                "\tsalary: " + salary +"\n";
    }

    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Shivanshu",22,56000));
        employees.add(new Employee("Shivam",22,55000));
        employees.add(new Employee("Shiv",20,70000));

        System.out.println("Before Sort:\n"+employees);
        Collections.sort(employees, new EmployeeSortOnAge());
        System.out.println("Before Sort:\n"+employees);
    }
}
