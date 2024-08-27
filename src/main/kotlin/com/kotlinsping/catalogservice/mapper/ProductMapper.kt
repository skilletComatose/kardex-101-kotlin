package com.kotlinsping.catalogservice.mapper

import com.kotlinsping.catalogservice.dto.ProductDto
import com.kotlinsping.catalogservice.dto.course.CourseDto
import com.kotlinsping.catalogservice.dto.course.CreateCourseDto
import com.kotlinsping.catalogservice.entity.Course
import com.kotlinsping.catalogservice.entity.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface ProductMapper {


//    @Mapping(target = "id", ignore = true)
//    fun toProduct(dto: CreateCourseDto) : Course


    fun toProductDto(entity: Product) : ProductDto

}