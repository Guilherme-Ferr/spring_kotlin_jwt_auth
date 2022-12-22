package br.com.vestcasa.vestreports.controllers.responses

import java.util.Date

data class ReportResponse(
    val id_report: Int,
    val id_report_type: Int,
    val name: String,
    val embedded_id: String,
    val image: String,
    val description: String,
    val created_at: Date,
    val updated_at: Date,
    val finished_at: Date? = null
)
