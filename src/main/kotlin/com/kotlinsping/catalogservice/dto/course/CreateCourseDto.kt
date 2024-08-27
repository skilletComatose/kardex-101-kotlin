package com.kotlinsping.catalogservice.dto.course
import jakarta.validation.constraints.NotEmpty

data class CreateCourseDto(
    @get:NotEmpty(message = "{error.required.field}")
    val name: String,

    @get:NotEmpty(message = "{error.required.field}")
    val category: String
)