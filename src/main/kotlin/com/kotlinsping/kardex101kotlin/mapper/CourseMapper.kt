package com.kotlinsping.kardex101kotlin.mapper

import com.kotlinsping.kardex101kotlin.dto.course.CourseDto
import com.kotlinsping.kardex101kotlin.dto.course.CreateCourseDto
import com.kotlinsping.kardex101kotlin.entity.Course
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CourseMapper {


    @Mapping(target = "id", ignore = true)
    fun toCourse(dto: CreateCourseDto) : Course

//    @Mapping(target = "id", source = "id")
    fun toCourseDto(entity: Course) : CourseDto

}