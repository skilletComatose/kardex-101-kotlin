package com.kotlinsping.kardex101kotlin.service

import com.kotlinsping.kardex101kotlin.dto.ProductDto
import com.kotlinsping.kardex101kotlin.dto.global.ResponseResult

interface ProductService {

    fun findAll(): ResponseResult<List<ProductDto>>

//    fun createProduct(product: CreateProductDto?): Product?

//    fun addStock(productId: Int, quantity: Int): Product
//    fun reduceStock(productId: Int, quantity: Int): Product

}