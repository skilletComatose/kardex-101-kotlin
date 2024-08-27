package com.kotlinsping.catalogservice.errorhandler

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

    @ExceptionHandler(Exception::class)
    fun genericException(error: Exception?): ResponseEntity<Any> {
        logger.error { error }
        return ResponseEntity.internalServerError()
            .body(ErrorResponse.internalServerError(INTERNAR_SERVER_ERROR))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(error: MethodArgumentNotValidException?): ResponseEntity<Any> {
        return ResponseEntity.badRequest()
            .body(
                ErrorResponse.fromBodyRequestErrors(
                    REQUEST_BODY_ERROR,
                    error!!
                )
            )
    }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleNoResourceFoundException(error: NoResourceFoundException?): ResponseEntity<Any> {
        return ResponseEntity.badRequest()
            .body(ErrorResponse.noResourceFound(NO_RESOURCE_FOUND))
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatchException(error: MethodArgumentTypeMismatchException): ResponseEntity<Any> {
        return ResponseEntity.badRequest()
            .body(
                ErrorResponse.of(
                    400,
                    REQUEST_BODY_ERROR,
                    FieldError(error.name, "Formato incorrecto")
                )
            )
    }

    companion object {
        const val REQUEST_BODY_ERROR: String = "Error en la información de entrada"
        const val INTERNAR_SERVER_ERROR: String = "Error en el servicio"
        const val NO_RESOURCE_FOUND: String = "Recurso no encontrado"
    }
}