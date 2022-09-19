package com.mercadolivro.excpetion

import com.mercadolivro.Controller.response.ErrorResponse
import com.mercadolivro.Controller.response.FieldErroResponse
import com.mercadolivro.enums.Errors
import net.bytebuddy.description.modifier.MethodArguments
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException.BadRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handlerNotFoundException(ex: NotFoundException, readable: WebRequest): ResponseEntity<ErrorResponse> {
       val erro = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handlerBadRequestException(ex: BadRequestException, readable: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, readable: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            ex.message,
            Errors.ML001.code,
            ex.bindingResult.fieldErrors.map { FieldErroResponse(it.defaultMessage ?: "invalid", it.field) }
        )

        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}