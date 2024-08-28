package com.kotlinsping.kardex101kotlin.repository

import com.kotlinsping.kardex101kotlin.entity.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Int> {
    override fun findAll(): List<Product>

    fun findByName(productName: String) : Product?
}