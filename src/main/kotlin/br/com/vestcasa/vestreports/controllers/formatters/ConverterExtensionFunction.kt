package br.com.vestcasa.vestreports.controllers.formatters

import br.com.vestcasa.vestreports.controllers.responses.PageResponse
import org.springframework.data.domain.Page

fun <T> Page<T>.paginate(): PageResponse<T> {
    return PageResponse(
        this.content,
        this.totalElements,
        this.number,
        this.totalPages
    )
}