package com.kotlinsping.catalogservice.errorhandler

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.web.bind.MethodArgumentNotValidException

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Error<T>(
    val error: T? = null
) {
    companion object {
        fun <T> of(error: T): Error<T> {
            return Error(error)
        }


        fun fromBodyRequestErrors(
            message: String,
            validationErrors: MethodArgumentNotValidException
        ): Error<List<FieldError>> {
            val fieldErrors = validationErrors.bindingResult.fieldErrors.map {
                FieldError(it.field, it.defaultMessage ?: "Unknown error")
            }
            return of(fieldErrors)
        }
    }
}