package br.com.vestcasa.vestreports.repositories

import br.com.vestcasa.vestreports.responseModels.UserDataClass
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsersRepository : JpaRepository<UserDataClass, Int> {
    @Query(
        nativeQuery = true,
        value = "select u.id_user, u.name, u.email, u.password, u.finished_at from vest_reports.users u where u.email = ?1 and u.finished_at is null"
    )
    fun findByEmail(email: String): UserDataClass
}
