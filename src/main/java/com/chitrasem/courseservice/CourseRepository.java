package com.chitrasem.courseservice;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends CrudRepository<Course,Long>, PagingAndSortingRepository<Course,Long>

{
  //  Page<Course> findAllPage(PageRequest pageRequest);
}
