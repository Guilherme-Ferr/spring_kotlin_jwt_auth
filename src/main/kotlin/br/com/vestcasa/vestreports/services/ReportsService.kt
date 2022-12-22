package br.com.vestcasa.vestreports.services

import br.com.vestcasa.vestreports.models.Report
import br.com.vestcasa.vestreports.exceptions.NotFoundException
import br.com.vestcasa.vestreports.models.ReportType
import br.com.vestcasa.vestreports.repositories.ReportTypesRepository
import br.com.vestcasa.vestreports.repositories.ReportsRepository
import org.springframework.stereotype.Service

@Service
class ReportsService(
    private val reportsRepository: ReportsRepository,
    private val reportTypesRepository: ReportTypesRepository
) {
    fun findAll(): List<Report> {
        return reportsRepository.findAll().toList()
    }

    fun findById(id: Int): Report? {
        return reportsRepository.findById(id).orElseThrow {
            NotFoundException(errorMessage = "Report")
        }
    }

    fun findAllTypes(): List<ReportType> {
        return reportTypesRepository.findAll().toList()
    }
}
