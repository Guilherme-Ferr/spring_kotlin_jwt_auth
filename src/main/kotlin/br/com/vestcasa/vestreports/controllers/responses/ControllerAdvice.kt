package br.com.vestcasa.vestreports.controllers.responses

import br.com.vestcasa.vestreports.controllers.responses.ErrorResponse
import br.com.vestcasa.vestreports.controllers.responses.FieldsError
import br.com.vestcasa.vestreports.exceptions.NotFoundException
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
            exception.message!!,
            listOf(FieldsError("${exception.errorMessage} Not Found", "id"))
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }
}