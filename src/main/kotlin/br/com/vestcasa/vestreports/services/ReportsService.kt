package br.com.vestcasa.vestreports.services

import br.com.vestcasa.vestreports.entities.Report
import br.com.vestcasa.vestreports.exceptions.Errors
import br.com.vestcasa.vestreports.exceptions.NotFoundException
import br.com.vestcasa.vestreports.repositories.ReportsRepository
import org.springframework.stereotype.Service

@Service
class ReportsService(
    private val reportsRepository: ReportsRepository
) {
    fun findAll(): List<Report> {
        return reportsRepository.findAll().toList()
    }

    fun findById(id: Int): Report? {
        return reportsRepository.findById(id).orElseThrow {
            NotFoundException(errorMessage = "Report")
        }
    }
}
