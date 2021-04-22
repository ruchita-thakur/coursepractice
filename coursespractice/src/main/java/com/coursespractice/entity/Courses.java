package com.coursespractice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="course_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="courseName", nullable=false)
	private String courseName;
	
	@Column(name="startDate", nullable=false)
	private LocalDate startDate;
	
	@Column(name="endDate", nullable=false)
	private LocalDate endDate;

	
	

}
