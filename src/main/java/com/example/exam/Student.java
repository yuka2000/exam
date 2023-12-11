package com.example.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private List<String> courses;

    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Courses: " + courses);
        System.out.println();
    }

    public static void main(String[] args) {
        
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("001", "Levi", 25);
        student1.addCourse("Computer Science");
        student1.addCourse("Mathematics");

        Student student2 = new Student("002", "Eren", 23);
        student2.addCourse("Computer Science");
        student2.addCourse("History");

        Student student3 = new Student("003", "Mikasa", 24);
        student3.addCourse("Physics");
        student3.addCourse("Biology");

        Student student4 = new Student("005", "Armin", 22);
        student4.addCourse("Chemistry");
        student4.addCourse("English");

        Student student5 = new Student("006", "Sasha", 22);
        student5.addCourse("Business");
        student5.addCourse("Marketing");

        Student student6 = new Student("007", "Hanji", 25);
        student6.addCourse("Physical education");
        student6.addCourse("Japanese");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        System.out.println("Details of students:");
        students.forEach(Student::displayDetails);

        String specificCourse = "Computer Science";
        System.out.println("\nStudents enrolled in the course \"" + specificCourse + "\":");
        students.stream()
                .filter(student -> student.getCourses().contains(specificCourse))
                .forEach(Student::displayDetails);

        String studentIdToUpdate = "003";
        int newAge = 25;
        System.out.println("\nUpdate the age of student with ID \"" + studentIdToUpdate + "\" to " + newAge + ":");
        students.stream()
                .filter(student -> student.getStudentId().equals(studentIdToUpdate))
                .forEach(student -> student.setAge(newAge));

        System.out.println("\nDetails of students after update age:");
        students.stream()
                .filter(student -> student.getStudentId().equals(studentIdToUpdate))
                .forEach(Student::displayDetails);

        double averageAge = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        System.out.println("\nAverage age of students: " + averageAge);
    }
}
