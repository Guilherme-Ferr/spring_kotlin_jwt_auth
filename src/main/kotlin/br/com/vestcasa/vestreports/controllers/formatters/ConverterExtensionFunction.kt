package br.com.vestcasa.vestreports.controllers.formatters

import br.com.vestcasa.vestreports.controllers.responses.ReportResponse
import br.com.vestcasa.vestreports.controllers.responses.ReportTypeResponse
import br.com.vestcasa.vestreports.models.Report
import br.com.vestcasa.vestreports.models.ReportType

fun Report.toResponse(): ReportResponse {
    return ReportResponse(
        id_report = this.id,
        id_report_type = this.reportType.id,
        name = this.name,
        description = this.description,
        embedded_id = this.embeddedId,
        image = this.image,
        created_at = this.createdAt,
        updated_at = this.updatedAt,
        finished_at = this.finishedAt
    )
}

fun ReportType.toResponse(): ReportTypeResponse {
    return ReportTypeResponse(
        id_report_type = this.id,
        name = this.name,
        created_at = this.createdAt,
        updated_at = this.updatedAt,
        finished_at = this.finishedAt
    )
}