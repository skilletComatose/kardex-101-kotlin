package com.kotlinsping.kardex101kotlin.errorhandler

import com.kotlinsping.kardex101kotlin.dto.global.ResponseResult
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.resource.NoResourceFoundException

@ControllerAdvice
class GlobalExceptionHandler {
    private val logger = KotlinLogging.logger {}
    companion object {
        const val REQUEST_BODY_ERROR: String = "Error en la información de entrada"
        const val INTERNAL_SERVER_ERROR: String = "Error en el servicio"
        const val NO_RESOURCE_FOUND: String = "Recurso no encontrado"
    }

    @ExceptionHandler(Exception::class)
    fun genericException(error: Exception): ResponseEntity<Any> {
        logger.error { error }
        return ResponseEntity.internalServerError()
            .body(ResponseResult.internalError<Any>(
                INTERNAL_SERVER_ERROR
            ))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(error: MethodArgumentNotValidException): ResponseEntity<Any> {
        return ResponseEntity.badRequest()
            .body(
                ResponseResult.badRequest<Any>(
                    Error.getBodyRequestErrors(
                        error
                    )
                )
            )
    }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleNoResourceFoundException(error: NoResourceFoundException): ResponseEntity<Any> {
        return ResponseEntity.badRequest()
            .body(ResponseResult.badRequest<Any>(
                NO_RESOURCE_FOUND
            ))
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatchException(error: MethodArgumentTypeMismatchException): ResponseEntity<Any> {
        return ResponseEntity.badRequest()
            .body(
                ResponseResult.badRequest<Any>(
                   listOf( FieldError(error.name, "Formato incorrecto"))
                )
            )
    }


}