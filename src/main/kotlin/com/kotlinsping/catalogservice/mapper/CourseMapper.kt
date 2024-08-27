package com.kotlinsping.catalogservice.mapper

import com.kotlinsping.catalogservice.dto.course.CourseDto
import com.kotlinsping.catalogservice.dto.course.CreateCourseDto
import com.kotlinsping.catalogservice.entity.Course
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CourseMapper {


    @Mapping(target = "id", ignore = true)
    fun toCourse(dto: CreateCourseDto) : Course

//    @Mapping(target = "id", source = "id")
    fun toCourseDto(entity: Course) : CourseDto

}