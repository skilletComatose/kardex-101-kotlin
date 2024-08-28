package com.kotlinsping.kardex101kotlin.service

import com.kotlinsping.kardex101kotlin.dto.product.ProductDto
import com.kotlinsping.kardex101kotlin.dto.global.ResponseResult
import com.kotlinsping.kardex101kotlin.dto.product.CreateProductDto

interface ProductService {

    fun findAll(): ResponseResult<List<ProductDto>>

    fun createProduct(createProductDto: CreateProductDto): ResponseResult<ProductDto>

//    fun addStock(productId: Int, quantity: Int): Product
//    fun reduceStock(productId: Int, quantity: Int): Product

}