package br.com.vestcasa.vestreports.controllers.responses

data class TokenPayload(
    val token: String
)

data class AuthenticateUserServiceResponse(
    val id_user: Int,
    val name: String,
    val email: String,
)