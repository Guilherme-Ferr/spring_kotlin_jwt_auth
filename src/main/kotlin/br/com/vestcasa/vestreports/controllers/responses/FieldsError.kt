package br.com.vestcasa.vestreports.controllers.responses

data class FieldsError(
    var message: String,
    var field: String? = null
)
