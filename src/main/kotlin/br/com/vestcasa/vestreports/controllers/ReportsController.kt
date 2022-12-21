package br.com.vestcasa.vestreports.controllers

import br.com.vestcasa.vestreports.entities.Report
import br.com.vestcasa.vestreports.services.ReportsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("reports")
class ReportsController(
    private val service: ReportsService
) {
    @GetMapping
    fun listAll(): List<Report> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Report? {
        return service.findById(id)
    }
}