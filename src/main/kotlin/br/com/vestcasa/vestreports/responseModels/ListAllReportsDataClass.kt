package br.com.vestcasa.vestreports.responseModels

import jakarta.persistence.*

@Entity
@Table(name = "reports", schema = "vest_reports")
data class ListAllReportsDataClass(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_report: Int,

    @Column
    val name: String,

    @Column
    val embedded_id: String,

    @Column
    val image: String,

    @Column
    val description: String,

//    @ManyToOne
//    @JoinColumn(name = "id_report_type")
//    val reportType: ReportType? = null,
//
//    @Column(name = "created_at")
//    val createdAt: Date? = null,
//
//    @Column(name = "updated_at")
//    val updatedAt: Date? = null,
//
//    @Column(name = "finished_at")
//    val finishedAt: Date? = null
)