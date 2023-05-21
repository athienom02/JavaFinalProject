package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseServiceTest {

    private CourseService courseService;

    @BeforeEach
    public void setUp() {
        courseService = new CourseService();
    }

    @Test
    public void testRegisterCourse() {
        Course course = new Course("INTRO-WEB-1", "Introduction to Web Applications", 9, new Module("INTRO-WEB-1", "Introduction to Web Applications", "Introduction to fundamentals of web development"));
        courseService.registerCourse(course);

        Course registeredCourse = courseService.getCourse("INTRO-WEB-1");
        Assertions.assertEquals(course, registeredCourse);
    }

    @Test
    public void testEnrollStudent() {
        Course course = new Course("INTRO-WEB-1", "Introduction to Web Applications", 9, new Module("INTRO-WEB-1", "Introduction to Web Applications", "Introduction to fundamentals of web development"));
        Student student = new Student("1", "Mary", "mary@gmail.com", null);
        courseService.enrollStudent(course.getCode(), student);

        List<Student> enrolledStudents = courseService.getEnrolledStudents(course.getCode());
        Assertions.assertTrue(enrolledStudents.contains(student));
    }

    private static class CourseService {
        private final Map<String, Course> courses = new HashMap<>();
        private final Map<String, List<Student>> enrolledStudents = new HashMap<>();

        public void registerCourse(Course course) {
            courses.put(course.getCode(), course);
        }

        public Course getCourse(String code) {
            if (courses.containsKey(code)) {
                return courses.get(code);
            }
            return null;
        }

        public void enrollStudent(String courseId, Student student) {
            if (!enrolledStudents.containsKey(courseId)) {
                enrolledStudents.put(courseId, new ArrayList<>());
            }
            enrolledStudents.get(courseId).add(student);
        }

        public List<Student> getEnrolledStudents(String courseId) {
            if (enrolledStudents.containsKey(courseId)) {
                return enrolledStudents.get(courseId);
            }
            return new ArrayList<>();
        }
    }
}