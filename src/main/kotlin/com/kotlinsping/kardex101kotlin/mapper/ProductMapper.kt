package com.kotlinsping.kardex101kotlin.mapper

import com.kotlinsping.kardex101kotlin.dto.product.CreateProductDto
import com.kotlinsping.kardex101kotlin.dto.product.ProductDto
import com.kotlinsping.kardex101kotlin.entity.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface ProductMapper {


    fun toProductDto(entity: Product) : ProductDto
    @Mapping(target = "productId", ignore = true)
    fun toProduct(dto: CreateProductDto) : Product

}