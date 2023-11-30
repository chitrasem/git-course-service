package com.chitrasem.courseservice;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private CoursService coursService;
    public CourseController(CoursService coursService){
        this.coursService = coursService;
    }

    // @GetMapping
    // public ResponseEntity<List<Course>> findAll(Pageable pageable){
    //     Page<Course> page = coursService.findAllCoursesPage(
    //         PageRequest.of(pageable.getPageNumber()
    //         , pageable.getPageSize()
    //         , pageable.getSortOr(Sort.by(Sort.Direction.ASC,"id"))
    //         )
    //     );
    //     return ResponseEntity.ok(page.getContent());
    // }

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        
        return ResponseEntity.ok(coursService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(
        @PathVariable Long id
    ){
        return ResponseEntity.ok( coursService.getCourseById(id));
    }


    @PostMapping
    public ResponseEntity<Void> saveCourse(@RequestBody Course newCourse, UriComponentsBuilder ucb){
        Course saveCourse = coursService.saveCourse(newCourse);
        URI locationOfNewCashCard = ucb
                .path("/api/course/{id}")
                .buildAndExpand(saveCourse.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewCashCard).build();

    }
    
    
}
