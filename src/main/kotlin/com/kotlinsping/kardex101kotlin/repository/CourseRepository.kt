package com.kotlinsping.kardex101kotlin.repository

import com.kotlinsping.kardex101kotlin.entity.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Int> {
}