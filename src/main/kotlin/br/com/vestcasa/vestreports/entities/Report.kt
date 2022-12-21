package br.com.vestcasa.vestreports.entities

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "reports", schema = "vest_reports")
data class Report(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_report")
    val id: Int,

    @ManyToOne
    @JoinColumn(name = "id_report_type")
    val report_type: ReportType,

    @Column
    val name: String,

    @Column
    val embedded_id: String,

    @Column
    val image: String,

    @Column
    val description: String,

    @Column(name = "created_at")
    val createdAt: Date,

    @Column(name = "updated_at")
    val updatedAt: Date,

    @Column(name = "finished_at")
    val finishedAt: Date
)