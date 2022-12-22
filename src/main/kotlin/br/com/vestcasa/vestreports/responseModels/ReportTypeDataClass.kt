package br.com.vestcasa.vestreports.responseModels

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "report_types", schema = "vest_reports")
data class ReportTypeDataClass(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_report_type: Int,

    @Column
    val name: String,

    @Column
    val created_at: Date? = null,

    @Column
    val updated_at: Date? = null,

    @Column
    val finished_at: Date? = null
)
