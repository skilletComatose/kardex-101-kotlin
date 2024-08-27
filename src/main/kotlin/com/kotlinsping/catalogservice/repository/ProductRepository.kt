package com.kotlinsping.catalogservice.repository

import com.kotlinsping.catalogservice.entity.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Int> {
    override fun findAll(): List<Product>
}