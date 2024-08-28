package com.kotlinsping.kardex101kotlin.service

import com.kotlinsping.kardex101kotlin.dto.course.CourseDto
import com.kotlinsping.kardex101kotlin.dto.course.CreateCourseDto

interface CourseService {

    fun addCourse(newCourse: CreateCourseDto) : CourseDto
}