package com.kotlinsping.kardex101kotlin.dto.product

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal


data class CreateProductDto(
    @get:NotEmpty(message = "{error.required.field}")
    val name: String,

    val description: String,

    @get:NotNull(message = "{error.required.field}")
    val categoryId: Int,

    @get:NotNull(message = "{error.required.field}")
    @get:Min(value = 0, message = "{error.positive.integer}")
    val price: BigDecimal,

    val imageUrl: String,

    @get:NotNull(message = "{error.required.field}")
    @get:Min(value = 1, message = "{error.stock.minimum}")
    val stockQuantity: Int
)
