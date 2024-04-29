package org.example.ta.Service;

import org.example.ta.Model.Courses;
import org.example.ta.Repository.ICourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourseDao courseDao;

    public List<String> getAllCourses() {
        List<Courses> allCourses = courseDao.findAll();
        List<String> courseStr = new ArrayList<>();

        for(Courses crs: allCourses){
            courseStr.add(crs.getName());
        }
        return courseStr;
    }
}
