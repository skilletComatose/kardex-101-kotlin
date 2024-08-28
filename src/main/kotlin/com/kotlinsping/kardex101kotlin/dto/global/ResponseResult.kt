package com.kotlinsping.kardex101kotlin.dto.global

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseResult<T>(
    val data: T? = null,
    val status: HttpStatus,
    val errors: Any? = null
) {
    companion object {

        fun <T> of(data: T?, status: HttpStatus, errors: Any?): ResponseResult<T > {
            return ResponseResult(data, status, errors)
        }

        fun <T> ok(data: T): ResponseResult<T> = of(data, HttpStatus.OK, null)
        fun <T> created(data: T): ResponseResult<T> = of(data, HttpStatus.CREATED, null)
        fun <T> badRequest(error: Any): ResponseResult<T> =
            of(null, HttpStatus.BAD_REQUEST, error)

        fun <T> internalError(error: Any): ResponseResult<T> =
            of(null, HttpStatus.INTERNAL_SERVER_ERROR, error)

        fun <T> notFound( error: Any) : ResponseResult<T> =
            of(null, HttpStatus.NOT_FOUND, error)

        fun <T> conflict(error: Any ): ResponseResult<T> =
            of(null, HttpStatus.CONFLICT, error)
    }
}