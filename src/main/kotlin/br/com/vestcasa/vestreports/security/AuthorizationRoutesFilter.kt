package br.com.vestcasa.vestreports.security

import br.com.vestcasa.vestreports.configs.JWTUtils
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter

class AuthorizationRoutesFilter(
    private val jwtUtils: JWTUtils
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = request.getHeader("Authorization").split(" ")[1]
        try {
            jwtUtils.validateToken(token)
            val user = jwtUtils.getClaimsFromUserToken(token)
            val authenticationToken = UsernamePasswordAuthenticationToken(user, null)
            authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authenticationToken
            filterChain.doFilter(request, response)
        } catch (ex: Exception) {
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token Expired")
        }
    }
}
