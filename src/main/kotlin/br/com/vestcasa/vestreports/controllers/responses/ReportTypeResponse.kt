package br.com.vestcasa.vestreports.controllers.responses

import java.util.Date

data class ReportTypeResponse(
    val id_report_type: Int,
    val name: String,
    val created_at: Date,
    val updated_at: Date,
    val finished_at: Date? = null
)
