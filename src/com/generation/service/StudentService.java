package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public void showSummary()
    {
        //TODO implement

        // Iterate over all students and print their information
        for (Student student : students.values()) {
            System.out.println(student.getName() + " (ID: " + student.getId() + ")");
            System.out.println("Approved Courses:");
            for (Course course : student.getApprovedCourses()) {
                System.out.println("- " + course.getName() + " (" + course.getCode() + ")");
            }
            System.out.println();
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        Student student = findStudent(studentId);
        if (student != null) {
            student.enrollToCourse(course);
        }
    }


}
