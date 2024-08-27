package com.kotlinsping.catalogservice.errorhandler

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.web.bind.MethodArgumentNotValidException

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse<T>(
    val status: Int,
    val error: String,
    val errorDetails: T? = null
) {
    companion object {
        fun of(status: Int, message: String): ErrorResponse<String> {
            return ErrorResponse(status, message, null)
        }

        fun <T> of(status: Int, message: String, errorDetails: T): ErrorResponse<T> {
            return ErrorResponse(status, message, errorDetails)
        }

        fun internalServerError(message: String): ErrorResponse<String> {
            return of(500, message)
        }

        fun noResourceFound(message: String): ErrorResponse<String> {
            return of(404, message)
        }

        fun fromBodyRequestErrors(
            message: String,
            validationErrors: MethodArgumentNotValidException
        ): ErrorResponse<List<FieldError>> {
            val fieldErrors = validationErrors.bindingResult.fieldErrors.map {
                FieldError(it.field, it.defaultMessage ?: "Unknown error")
            }
            return ErrorResponse(400, message, fieldErrors)
        }
    }
}