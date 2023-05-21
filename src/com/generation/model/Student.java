package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person implements Evaluation {
    private double average;
    private final List<Course> courses = new ArrayList<>(); // List of enrolled courses
    private final Map<Course, Double> grades = new HashMap<>(); // Map of course grades

    public Student(String id, String name, String email, Date birthDate) {
        super(id, name, email, birthDate);
    }

    public void enrollToCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course); // Add the course to the list of enrolled courses
        }
    }

    public void setGrade(Course course, double grade) {
        if (courses.contains(course)) {
            grades.put(course, grade); // Set the grade for the given course
        }
    }

    public List<Course> findPassedCourses(Course course) {
        List<Course> passedCourses = new ArrayList<>();

        for (Map.Entry<Course, Double> entry : grades.entrySet()) {
            Course enrolledCourse = entry.getKey();
            double grade = entry.getValue();
            if (enrolledCourse.equals(course) && grade >= 50) {
                passedCourses.add(enrolledCourse);
            }
        }

        return passedCourses;
    }

    public double calculateAverageGrade() {
        double total = 0;
        int count = 0;

        for (double grade : grades.values()) {
            total += grade;
            count++;
        }

        return total / count;
    }

    public List<Course> getApprovedCourses() {
        List<Course> approvedCourses = new ArrayList<>();

        for (Map.Entry<Course, Double> entry : grades.entrySet()) {
            Course course = entry.getKey();
            double grade = entry.getValue();
            if (grade >= 50) {
                approvedCourses.add(course);
            }
        }

        return approvedCourses;
    }

    public boolean isAttendingCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return true; // Check if the student is attending the given course
            }
        }
        return false;
    }

    @Override
    public double getAverage() {
        return average; // Return the student's average
    }

    @Override
    public String toString() {
        return "Student {" + super.toString() + "}";
    }
}