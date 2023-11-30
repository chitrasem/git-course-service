package com.chitrasem.courseservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoursService {
    
    private final CourseRepository courseRepository;

    public CoursService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    // public Page<Course> findAllCoursesPage(Pageable pageRequest){
    //     return courseRepository.findAllPage(pageRequest);
    // }
    public List<Course> findAll(){
        return (ArrayList) courseRepository.findAll();
    }
    public Course getCourseById(Long id){
        return courseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Course not found for id: " + id));
    }
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    
}
