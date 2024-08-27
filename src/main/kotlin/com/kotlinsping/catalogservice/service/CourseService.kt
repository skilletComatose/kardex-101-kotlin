package com.kotlinsping.catalogservice.service

import com.kotlinsping.catalogservice.dto.course.CourseDto
import com.kotlinsping.catalogservice.dto.course.CreateCourseDto
import com.kotlinsping.catalogservice.entity.Course

interface CourseService {

    fun addCourse(newCourse: CreateCourseDto) : CourseDto
}