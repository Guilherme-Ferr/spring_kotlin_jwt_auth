package br.com.vestcasa.vestreports.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "report_types", schema = "vest_reports")
data class ReportType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_report_type")
    val id: Int,

    @Column
    val name: String,

    @Column(name = "created_at")
    val createdAt: Date,

    @Column(name = "updated_at")
    val updatedAt: Date,

    @Column(name = "finished_at")
    val finishedAt: Date
)
