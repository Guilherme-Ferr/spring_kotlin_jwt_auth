package br.com.vestcasa.vestreports.controllers

import br.com.vestcasa.vestreports.controllers.formatters.toResponse
import br.com.vestcasa.vestreports.controllers.responses.ReportResponse
import br.com.vestcasa.vestreports.controllers.responses.ReportTypeResponse
import br.com.vestcasa.vestreports.services.ReportsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("reports")
class ReportsController(
    private val reportsService: ReportsService
) {
    @GetMapping
    fun listAll(): List<ReportResponse> {
        return reportsService.findAll().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ReportResponse? {
        return reportsService.findById(id)?.toResponse()
    }

    @GetMapping("/types")
    fun findAllTypes(): List<ReportTypeResponse> {
        return reportsService.findAllTypes().map { it.toResponse() }
    }
}