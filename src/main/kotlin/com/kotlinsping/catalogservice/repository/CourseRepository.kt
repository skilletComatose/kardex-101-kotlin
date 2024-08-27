package com.kotlinsping.catalogservice.repository

import com.kotlinsping.catalogservice.entity.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Int> {
}