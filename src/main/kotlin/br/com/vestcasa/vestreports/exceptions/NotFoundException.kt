package br.com.vestcasa.vestreports.exceptions

import org.cef.handler.CefLoadHandler.ErrorCode

class NotFoundException(override val message: String): Exception() {}
