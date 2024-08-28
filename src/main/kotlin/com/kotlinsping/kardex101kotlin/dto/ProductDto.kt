package com.kotlinsping.kardex101kotlin.dto

import com.kotlinsping.kardex101kotlin.entity.Category
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductDto (
    val productId: Int?,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val stockQuantity: Int,
    val imageUrl: String? = null,
    val category: Category,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime

)