package br.com.vestcasa.vestreports.services

import br.com.vestcasa.vestreports.controllers.formatters.formatAuthenticationResponse
import br.com.vestcasa.vestreports.controllers.requests.AuthenticateUserRequest
import br.com.vestcasa.vestreports.controllers.responses.AuthenticateUserServiceResponse
import br.com.vestcasa.vestreports.exceptions.NotFoundException
import br.com.vestcasa.vestreports.repositories.UsersRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsersService(
    private val usersRepository: UsersRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
) {
    fun authenticateUser(request: AuthenticateUserRequest): AuthenticateUserServiceResponse {
        val user = usersRepository.findByEmail(request.email)
        return if (bCryptPasswordEncoder.matches(request.password, user.password)) user.formatAuthenticationResponse()
        else {
            throw NotFoundException(paramNotFound = "User")
        }
    }
}
