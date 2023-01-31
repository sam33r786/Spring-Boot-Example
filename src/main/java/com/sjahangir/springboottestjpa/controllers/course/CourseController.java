package com.sjahangir.springboottestjpa.controllers.course;

import com.sjahangir.springboottestjpa.models.course.Course;
import com.sjahangir.springboottestjpa.services.course.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(final CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable final int id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody final Course course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable final int id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("courses/{id}")
    public Course updateCourse(@PathVariable final int id, @RequestBody final Course course) {
        return courseService.updateCourse(id, course);
    }
}
