package br.com.vestcasa.vestreports.controllers

import br.com.vestcasa.vestreports.controllers.formatters.paginate
import br.com.vestcasa.vestreports.controllers.responses.PageResponse
import br.com.vestcasa.vestreports.responseModels.ListAllReportsDataClass
import br.com.vestcasa.vestreports.responseModels.ReportTypeDataClass
import br.com.vestcasa.vestreports.services.ReportsService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("reports")
class ReportsController(
    private val reportsService: ReportsService
) {
    @GetMapping
    fun listAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): PageResponse<ListAllReportsDataClass> {
        return reportsService.listAll(pageable, 5).paginate()
    }

    @GetMapping("/types")
    fun findAllTypes(@PageableDefault(page = 0, size = 10) pageable: Pageable): PageResponse<ReportTypeDataClass> {
        return reportsService.findAllTypes(pageable).paginate()
    }
}