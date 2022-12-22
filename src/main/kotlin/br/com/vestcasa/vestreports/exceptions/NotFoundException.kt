package br.com.vestcasa.vestreports.exceptions

import org.cef.handler.CefLoadHandler.ErrorCode

class NotFoundException(
    override val message: String? = "not found",
    val errorMessage: String
) : Exception() {}
