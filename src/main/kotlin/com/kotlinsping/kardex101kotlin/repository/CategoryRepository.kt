package com.kotlinsping.kardex101kotlin.repository

import com.kotlinsping.kardex101kotlin.entity.Category
import com.kotlinsping.kardex101kotlin.entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

interface CategoryRepository : CrudRepository<Category, Int> {
    override fun findAll(): List<Category>

}
