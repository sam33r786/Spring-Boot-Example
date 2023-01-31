package com.sjahangir.springboottestjpa.services.course;

import com.sjahangir.springboottestjpa.models.course.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static final List<Course> COURSES = new ArrayList<>();
    private static int userId = 0;

    static {
        COURSES.add(new Course(userId++, "Computer Science", "Tony"));
        COURSES.add(new Course(userId++, "Computer Design", "Ian"));
        COURSES.add(new Course(userId++, "Computing For Business", "Peter"));
    }

    public List<Course> getAllCourses() {
        return COURSES;
    }

    public Course getCourseById(final int id) {
        return COURSES.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
    }

    public Course addCourse(final Course course) {
        course.setId(userId++);
        COURSES.add(course);
        return course;
    }

    public boolean deleteCourse(final int id) {
        return COURSES.removeIf(course -> course.getId() == id);
    }

    public Course updateCourse(final int id, final Course updatedCourse) {
        Course findById = COURSES.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
        int index = COURSES.indexOf(findById);
        COURSES.remove(findById);
        updatedCourse.setId(id);
        COURSES.add(index, updatedCourse);
        return updatedCourse;
    }
}
