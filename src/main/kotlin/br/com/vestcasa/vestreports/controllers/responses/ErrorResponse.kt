package br.com.vestcasa.vestreports.controllers.responses

data class ErrorResponse(
    var message: String,
    var errors: List<FieldsError>?
)