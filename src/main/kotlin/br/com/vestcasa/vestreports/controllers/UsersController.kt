package br.com.vestcasa.vestreports.controllers

import br.com.vestcasa.vestreports.configs.JWTUtils
import br.com.vestcasa.vestreports.controllers.requests.AuthenticateUserRequest
import br.com.vestcasa.vestreports.controllers.responses.ControllerResponse
import br.com.vestcasa.vestreports.controllers.responses.TokenPayload
import br.com.vestcasa.vestreports.services.UsersService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UsersController(
    private val usersService: UsersService,
    private val jwtUtils: JWTUtils
) {
    @PostMapping("/login")
    fun authenticateUser(@RequestBody body: AuthenticateUserRequest): ControllerResponse {
        val validateUser = usersService.authenticateUser(body)
        val token = jwtUtils.generateToken(validateUser)
        return ControllerResponse("ok", TokenPayload(token))
    }
}
