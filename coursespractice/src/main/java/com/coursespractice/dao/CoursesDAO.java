package com.coursespractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coursespractice.entity.Courses;

public interface CoursesDAO extends JpaRepository<Courses,Integer> {

}
