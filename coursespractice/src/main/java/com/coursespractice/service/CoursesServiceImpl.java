package com.coursespractice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.coursespractice.dao.CoursesDAO;
import com.coursespractice.entity.Courses;
import com.coursespractice.exception.CoursesException;

@Service
public class CoursesServiceImpl implements CoursesService {
	
	@Autowired
	private CoursesDAO coursesDao;
	
	public int addcourses(Courses course) throws CoursesException {
		try {
			coursesDao.save(course);
			return 1;
		}
		catch(DataAccessException e) {
			throw new CoursesException(e.getMessage(),e);
		}
		catch(Exception e) {
			throw new CoursesException(e.getMessage(),e);
		}
		
	}
	
	public Courses getCoursesById(Integer id) throws CoursesException{
		try {
			Optional<Courses> optional=coursesDao.findById(id);
					if(optional.isPresent()) {
						return optional.get();
					}
					else {
						return null;
					}
		}
		catch(DataAccessException e) {
			
			throw new CoursesException(e.getMessage(),e);
		}
		catch(Exception e) {
			
			throw new CoursesException(e.getMessage(),e);
		}
		
	}
	
	public Integer deleteCourseById(Integer id) throws CoursesException{
		try {
			coursesDao.deleteById(id);
			return 1;
		}
		catch(DataAccessException e) {
			throw new CoursesException(e.getMessage(),e);
		}
		catch(Exception e) {
			throw new CoursesException(e.getMessage(),e);
		}
	}
	
	public Integer updateCourseById(Courses course,Integer id) throws CoursesException{
		try {
			course.setId(id);
			coursesDao.save(course);
			return 1;
		}
		catch(DataAccessException e) {
			throw new CoursesException(e.getMessage(),e);
			
		}
		catch(Exception e) {
			throw new CoursesException(e.getMessage(),e);
		}
	}
	
	
	public List<Courses> getAllCoureses() throws CoursesException{
		try 
		{			
			List<Courses> couresesList =coursesDao.findAll();
			return couresesList;
		}
		catch(DataAccessException e) 
		{
			throw new CoursesException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new CoursesException(e.getMessage(),e);
		}
	}
	

}
