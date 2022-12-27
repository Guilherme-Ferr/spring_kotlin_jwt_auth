package br.com.vestcasa.vestreports.controllers.formatters

import br.com.vestcasa.vestreports.controllers.responses.AuthenticateUserServiceResponse
import br.com.vestcasa.vestreports.controllers.responses.PageResponse
import br.com.vestcasa.vestreports.responseModels.UserDataClass
import org.springframework.data.domain.Page

fun <T> Page<T>.paginate(): PageResponse<T> {
    return PageResponse(
        this.content,
        this.totalElements,
        this.number,
        this.totalPages
    )
}

fun UserDataClass.formatAuthenticationResponse(): AuthenticateUserServiceResponse {
    return AuthenticateUserServiceResponse(
        id_user = this.id_user,
        name = this.name,
        email = this.email,
    )
}
