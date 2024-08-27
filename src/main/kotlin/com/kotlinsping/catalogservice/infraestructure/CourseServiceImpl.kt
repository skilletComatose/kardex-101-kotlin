package com.kotlinsping.catalogservice.infraestructure

import com.kotlinsping.catalogservice.dto.course.CourseDto
import com.kotlinsping.catalogservice.dto.course.CreateCourseDto
import com.kotlinsping.catalogservice.entity.Course
import com.kotlinsping.catalogservice.mapper.CourseMapper
import com.kotlinsping.catalogservice.repository.CourseRepository
import com.kotlinsping.catalogservice.service.CourseService
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(
    private val courserRepository: CourseRepository,
    private val courseMapper: CourseMapper
) : CourseService {


    override fun addCourse(newCourse: CreateCourseDto): CourseDto {
        return toEntity(newCourse)
                .let { save(it) }
                .let { toDto(it) }
    }


    private fun toEntity(dto: CreateCourseDto): Course = courseMapper.toCourse(dto)

    private fun toDto(entity: Course) : CourseDto  = courseMapper.toCourseDto(entity);


    private fun save(entity: Course): Course = courserRepository.save(entity)

}