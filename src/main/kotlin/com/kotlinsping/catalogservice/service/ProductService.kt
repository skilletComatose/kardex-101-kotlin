package com.kotlinsping.catalogservice.service

import com.kotlinsping.catalogservice.entity.Product

interface ProductService {

    fun findAll(): List<Product?>

//    fun createProduct(product: CreateProductDto?): Product?

//    fun addStock(productId: Int, quantity: Int): Product
//    fun reduceStock(productId: Int, quantity: Int): Product

}