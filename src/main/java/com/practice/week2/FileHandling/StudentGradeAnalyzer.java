package com.practice.week2.FileHandling;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class StudentGradeAnalyzer {
    private Map<String, Student> students = new HashMap<>();

    public void readFile(String fileName) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = reader.readLine()) !=null)
        {
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            double grade = Double.parseDouble(parts[2]);
            if(!students.containsKey(id)){
                students.put(id, new Student(name, id));
            }
            students.get(id).addGrade(grade);
        }
        reader.close();
    }
    public void calculateAverage(){
        for(Student student:students.values()){
            student.calculateAverageGrade();
        }
    }

    public void printResults()
    {
        for(Student student:students.values()){
            System.out.println(student);
        }
    }

    public static void main(String[] args)
    {
        StudentGradeAnalyzer analyzer = new StudentGradeAnalyzer();
        String fileName = "studentGrades.txt";
        try {
            analyzer.readFile(fileName);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        analyzer.calculateAverage();
        analyzer.printResults();

    }
}
