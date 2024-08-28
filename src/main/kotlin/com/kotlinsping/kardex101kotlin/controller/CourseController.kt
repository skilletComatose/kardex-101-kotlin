package com.kotlinsping.kardex101kotlin.controller

import com.kotlinsping.kardex101kotlin.dto.course.CourseDto
import com.kotlinsping.kardex101kotlin.dto.course.CreateCourseDto
import com.kotlinsping.kardex101kotlin.service.CourseService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/courses")
class CourseController(
    private val courseService: CourseService
) {

    @PostMapping
    fun addCourse(@Valid @RequestBody request: CreateCourseDto): ResponseEntity<CourseDto> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(courseService.addCourse(request))
    }
}