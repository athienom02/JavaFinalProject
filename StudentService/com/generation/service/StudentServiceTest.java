package com.generation.service;

import com.generation.model.Module;
import com.generation.model.Course;
import com.generation.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        studentService = new StudentService();
    }

    @Test
    public void testSubscribeStudent() {
        Student student = new Student("1", "Mary", "mary@gmail.com", null);
        studentService.subscribeStudent(student);

        Student subscribedStudent = studentService.findStudent("1");
        Assertions.assertEquals(student, subscribedStudent);
    }

    @Test
    public void testEnrollToCourse() {
        Student student = new Student("1", "Mary", "mary@gmail.com", null);
        Course course = new Course("INTRO-WEB-1", "Introduction to Web Applications", 9, new Module("moduleWebFundamentals", "Web Fundamentals", "Introduction to web development"));
        studentService.subscribeStudent(student);
        studentService.enrollToCourse("1", course);

        Assertions.assertTrue(student.isAttendingCourse("INTRO-WEB-1"));
    }

}