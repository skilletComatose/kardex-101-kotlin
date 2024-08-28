package com.kotlinsping.kardex101kotlin.infraestructure

import com.kotlinsping.kardex101kotlin.dto.course.CourseDto
import com.kotlinsping.kardex101kotlin.dto.course.CreateCourseDto
import com.kotlinsping.kardex101kotlin.entity.Course
import com.kotlinsping.kardex101kotlin.mapper.CourseMapper
import com.kotlinsping.kardex101kotlin.repository.CourseRepository
import com.kotlinsping.kardex101kotlin.service.CourseService
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