package br.com.vestcasa.vestreports.controllers.responses

class PageResponse<T>(
    var items: List<T>,
    var totalItems: Long,
    var currentPage: Int,
    var totalPages: Int,
)