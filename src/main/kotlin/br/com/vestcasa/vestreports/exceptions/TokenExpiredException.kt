package br.com.vestcasa.vestreports.exceptions

class TokenExpiredException(
    override val message: String = Errors.EXP.message,
) : Exception()