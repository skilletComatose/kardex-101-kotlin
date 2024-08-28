package com.kotlinsping.kardex101kotlin.errorhandler

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.web.bind.MethodArgumentNotValidException

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Error<T>(
    val error: T? = null
) {
    companion object {
        fun <T> of(t: T): Error<T> {
            return Error(t)
        }


        fun fromBodyRequestErrors(
            validationErrors: MethodArgumentNotValidException
        ): Error<List<FieldError>> {
            return of(getBodyRequestErrors(validationErrors))
        }

        fun getBodyRequestErrors(validationErrors: MethodArgumentNotValidException): List<FieldError> {
            return validationErrors.bindingResult.fieldErrors.map {
                FieldError(it.field, it.defaultMessage ?: "Unknown error")
            }
        }
    }
}