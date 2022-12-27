package br.com.vestcasa.vestreports.controllers.requests

data class AuthenticateUserRequest(
  val email: String,
  val password: String
)