package br.com.vestcasa.vestreports.exceptions

class NotFoundException(
    override val message: String = Errors.NF.message,
    val paramNotFound: String
) : Exception()
