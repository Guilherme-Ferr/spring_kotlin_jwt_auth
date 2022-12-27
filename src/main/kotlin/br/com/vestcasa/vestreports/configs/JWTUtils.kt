package br.com.vestcasa.vestreports.configs

import br.com.vestcasa.vestreports.controllers.responses.AuthenticateUserServiceResponse
import br.com.vestcasa.vestreports.exceptions.UserAuthException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.naming.AuthenticationException

@Component
class JWTUtils {
    @Value("\${jwt.secret}")
    private val jwtSecret: String? = null

    fun generateToken(user: AuthenticateUserServiceResponse): String {
        return Jwts.builder()
            .claim("id_user", user.id_user)
            .claim("name", user.name)
            .claim("email", user.email)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000))
            .signWith(SignatureAlgorithm.HS512, jwtSecret!!.toByteArray())
            .compact()
    }

    fun getClaimsFromUserToken(token: String): Claims {
        try {
            return Jwts.parser().setSigningKey(jwtSecret!!.toByteArray()).parseClaimsJws(token).body
        } catch (ex: Exception) {
            throw UserAuthException()
        }
    }
}
