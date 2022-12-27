package br.com.vestcasa.vestreports.exceptions

class UserAuthException(
    override val message: String = Errors.FB.message,
) : Exception()
