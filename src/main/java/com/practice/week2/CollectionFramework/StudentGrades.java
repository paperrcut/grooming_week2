package com.practice.week2.CollectionFramework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
@NoArgsConstructor
public class StudentGrades {
    private List<Student> students = new ArrayList<>();
    private Set<String> rollNoSet = new HashSet<>();
    private HashMap<String, List<Double>> studentGrades = new HashMap<>();

    public boolean addStudent(Student student)
    {
        if(rollNoSet.contains(student.getRoll()))
        {
            System.out.println("Student already exists.");
            return false;
        }
        else {
            rollNoSet.add(student.getRoll());
            studentGrades.put(student.getName(), new ArrayList<>());
            students.add(student);
            return true;
        }
    }

    public boolean removeStudent(String roll)
    {
        if(rollNoSet.contains(roll))
        {
            Student studentToRemove = findStudent(roll);
            rollNoSet.remove(roll);
            students.remove(studentToRemove);
            studentGrades.remove(studentToRemove.getName());
            return true;
        }
        return false;
    }

    public Student findStudent(String roll)
    {
        return  students.stream()
                .filter(student -> roll.equals(student.getRoll()))
                .findAny()
                .orElse(null);
    }

    public double updateAverageGrade(Student student)
    {
        List<Double> grades=studentGrades.get(student.getName());
        double averageGrade = grades.stream()
            .mapToDouble(Double::doubleValue)
            .sum()/grades.size();

        student.setAverageGrade(averageGrade);
        return averageGrade;
    }
    public boolean addGrade(String roll, double grade)
    {
        if(rollNoSet.contains(roll)) {
            Student stud = findStudent(roll);
            List<Double> grades = studentGrades.get(stud.getName());
            grades.add(grade);
            studentGrades.replace(roll, grades);
            updateAverageGrade(stud);
            return true;
        }
        else {
            System.out.println("Student not present.");
            return false;
        }
    }

    public boolean removeGrade(String roll, double grade)
    {
        if(rollNoSet.contains(roll)) {
            Student stud = findStudent(roll);
            List<Double> grades = studentGrades.get(stud.getName());
            grades.remove(grade);
            studentGrades.replace(roll, grades);
            updateAverageGrade(stud);
            return true;
        }
        else {
            System.out.println("Student not present.");
            return false;
        }
    }

    public List<Student> sortStudent(String sortType)
    {
        if(sortType.equalsIgnoreCase("name")){
            Collections.sort(students,new StudentSortOnName());
        }
        else if(sortType.equalsIgnoreCase("grade")){
            Collections.sort(students,new StudentSortOnGrade());
        }
        else
            System.out.println("Wrong sort type");

        return students;
    }

    public Student getTopPerformer()
    {
        Student topPerformer= null;
        double maxAvgGrade=0.0;
        for(Student stud:students)
        {
            if(stud.getAverageGrade()>maxAvgGrade) {
                maxAvgGrade = stud.getAverageGrade();
                topPerformer = stud;
            }
        }
        return topPerformer;
    }

    public static void main(String[] args)
    {
        StudentGrades studGrades = new StudentGrades();
        Student s1 = new Student("Shivanshu","1");
        Student s2 = new Student("Shivam","2");

        studGrades.addStudent(s1);
        studGrades.addStudent(s2);

        studGrades.addGrade(s1.getRoll(), 90);
        studGrades.addGrade(s1.getRoll(), 80);

        studGrades.addGrade(s2.getRoll(), 95);
        studGrades.addGrade(s2.getRoll(), 85);

        for(Map.Entry<String,List<Double>> sg: studGrades.getStudentGrades().entrySet())
        {
            System.out.println((sg.getKey()+" : "+sg.getValue()));
        }
        System.out.println("Before Sort:");
        System.out.println(studGrades.getStudents());

        studGrades.sortStudent("name");
        System.out.println("After Sort by name:");
        System.out.println(studGrades.getStudents());

        studGrades.sortStudent("grade");
        System.out.println("After Sort by grade:");
        System.out.println(studGrades.getStudents());

        System.out.println("Topper: "+studGrades.getTopPerformer().getName());

        System.out.println("Add grade to roll 1:");
        studGrades.addGrade(s1.getRoll(), 100);
        System.out.println(studGrades.getStudents());

        System.out.println("Remove grade from roll 1:");
        studGrades.removeGrade(s1.getRoll(), 100);
        System.out.println(studGrades.getStudents());

        System.out.println("Remove roll 2:");
        studGrades.removeStudent(s2.getRoll());
        System.out.println(studGrades.getStudents());
    }
}
