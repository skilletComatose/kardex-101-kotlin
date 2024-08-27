package com.kotlinsping.catalogservice.service

import com.kotlinsping.catalogservice.dto.ProductDto
import com.kotlinsping.catalogservice.dto.global.ResponseResult

interface ProductService {

    fun findAll(): ResponseResult<List<ProductDto>>

//    fun createProduct(product: CreateProductDto?): Product?

//    fun addStock(productId: Int, quantity: Int): Product
//    fun reduceStock(productId: Int, quantity: Int): Product

}