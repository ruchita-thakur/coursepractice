package com.coursespractice.service;

import java.util.List;

import com.coursespractice.entity.Courses;
import com.coursespractice.exception.CoursesException;

public interface CoursesService {
	
	public int addcourses(Courses course) throws CoursesException ;
	
	public Courses getCoursesById(Integer id) throws CoursesException;
	
	public Integer deleteCourseById(Integer id) throws CoursesException;
	
	public Integer updateCourseById(Courses course,Integer id) throws CoursesException;
	
	public List<Courses> getAllCoureses() throws CoursesException;

}
