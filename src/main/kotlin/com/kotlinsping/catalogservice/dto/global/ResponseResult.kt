package com.kotlinsping.catalogservice.dto.global

import com.fasterxml.jackson.annotation.JsonInclude
import com.kotlinsping.catalogservice.errorhandler.Error
import org.springframework.http.HttpStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseResult<T>(
    val data: T? = null,
    val status: HttpStatus,
    val errors: Error<Any>? = null
) {
    companion object {

        fun <T> of(t: T, status: HttpStatus): ResponseResult<T> = ResponseResult(t, status)
        fun <T> ok(t: T): ResponseResult<T> = of(t, HttpStatus.OK)
        fun <T> created(t: T): ResponseResult<T> = of(t, HttpStatus.CREATED)
        fun <T> badRequest(t: T): ResponseResult<T> = of(t, HttpStatus.BAD_REQUEST)
        fun <T> internalError(t: T): ResponseResult<T> = of(t, HttpStatus.INTERNAL_SERVER_ERROR)
        fun <T> notFound(t: T): ResponseResult<T> = of(t, HttpStatus.NOT_FOUND)
    }
}