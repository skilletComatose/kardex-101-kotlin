package com.kotlinsping.kardex101kotlin.mapper

import com.kotlinsping.kardex101kotlin.dto.ProductDto
import com.kotlinsping.kardex101kotlin.entity.Product
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ProductMapper {


//    @Mapping(target = "id", ignore = true)
//    fun toProduct(dto: CreateCourseDto) : Course


    fun toProductDto(entity: Product) : ProductDto

}