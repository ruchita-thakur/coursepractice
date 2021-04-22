package com.coursespractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.coursespractice.entity.Courses;
import com.coursespractice.exception.CoursesException;
import com.coursespractice.service.CoursesService;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:3000")
public class CoursesController {
	
	@Autowired
	private CoursesService coursesService;
	
	
	@PostMapping("/courses")
	public String addCourses(@RequestBody Courses course) {
		
		try {
			Integer status=coursesService.addcourses(course);
			if(status==1) {
				return "Course added to the database";
			}
			else {
				return "Course could not be added";
			}
		} catch(CoursesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity getCourseById(@PathVariable ("id") Integer id) {
		try {
			Courses course=coursesService.getCoursesById(id);
			return new ResponseEntity(course,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping("/courses/{id}")
	public String deleteCourseById(@PathVariable ("id") Integer id) {
		try {
			Integer status=coursesService.deleteCourseById(id);
			if(status==1) {
				return "Course deleted successfully from database";
			}
			else {
				return "Unable to delete course from database";
			}
		}
		catch(CoursesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PutMapping("/courses/{id}")
	public String updateCoursesByid(@RequestBody Courses course,@PathVariable("id") Integer id) {
		try {
			Integer i=coursesService.updateCourseById(course,id);
			if(i>0) {
				return "Course updated successfully";
			}
			else {
				return "Course could not be edited";
			}
		}
		catch(CoursesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	

	@GetMapping("/courses")
	public List<Courses> getAllEmployees() throws CoursesException{
		return coursesService.getAllCoureses();
	}


}
