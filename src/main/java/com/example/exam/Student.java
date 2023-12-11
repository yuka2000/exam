package com.example.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String studentID;
    private String name;
    private int age;
    private List<String> courses;

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Courses: " + courses);
        System.out.println();
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();


        students.add(new Student("123", "Levi", 30));
        students.get(0).addCourse("Physical education");
        students.get(0).addCourse("Track and field");

        students.add(new Student("456", "Eren", 20));
        students.get(1).addCourse("Computer programming");
        students.get(1).addCourse("HTML");

        students.add(new Student("789", "Mikasa", 20));
        students.get(2).addCourse("Science");
        students.get(2).addCourse("Biology");

        students.add(new Student("012", "Armin", 20));
        students.get(3).addCourse("Business");
        students.get(3).addCourse("Accounting");


        System.out.println("Details of all students:");
        students.forEach(Student::displayDetails);


        String specificCourse = "Computer Programming";
        System.out.println("Students enrolled in '" + specificCourse + "':");
        students.stream()
                .filter(student -> student.getCourses().contains(specificCourse))
                .forEach(Student::displayDetails);


        String studentIDToUpdate = "456";
        int newAge = 20;
        System.out.println("Update the age of student with ID '" + studentIDToUpdate + "' to " + newAge + ":");
        students.stream()
                .filter(student -> student.getStudentID().equals(studentIDToUpdate))
                .forEach(student -> student.age = newAge);
        
        System.out.println("Details of students after update age:");
        students.forEach(Student::displayDetails);


        double averageAge = students.stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Average Age of students: " + averageAge);
    }
}
