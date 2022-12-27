package br.com.vestcasa.vestreports.responseModels

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "users", schema = "vest_reports")
data class UserDataClass(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_user: Int,

    @Column
    val name: String,

    @Column
    val email: String,

    @Column
    val password: String?,

    @Column
    val finished_at: Date?
)
