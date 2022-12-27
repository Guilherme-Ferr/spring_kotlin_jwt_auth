package br.com.vestcasa.vestreports.exceptions.config

import br.com.vestcasa.vestreports.controllers.responses.ErrorResponse
import br.com.vestcasa.vestreports.controllers.responses.FieldsError
import br.com.vestcasa.vestreports.exceptions.NotFoundException
import br.com.vestcasa.vestreports.exceptions.TokenExpiredException
import br.com.vestcasa.vestreports.exceptions.UserAuthException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            exception.message,
            listOf(FieldsError("${exception.paramNotFound} Not Found", "id"))
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(UserAuthException::class)
    fun handleUserAuthException(exception: UserAuthException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            exception.message,
            listOf(FieldsError("User Token Forbidden", "authorization"))
        )
        return ResponseEntity(error, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(exception: TokenExpiredException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            exception.message,
            listOf(FieldsError("Token Expired", "authorization"))
        )
        return ResponseEntity(error, HttpStatus.UNAUTHORIZED)
    }
}