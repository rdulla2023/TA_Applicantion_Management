package org.example.ta.Controller;


import org.example.ta.Model.Courses;
import org.example.ta.Repository.ICourseDao;
import org.example.ta.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    ICourseDao courseDao;

    //Get All Courses
    @CrossOrigin(origins ="*")
    @GetMapping(value = "/getAllCourses")
    public List<String> getAllCourses(){
        return courseService.getAllCourses();
    }

    //Create Course
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/saveCourse")
    public String saveCourse (@RequestBody Courses course){
        courseDao.save(course);
        return "Course Saved !";
    }

}
