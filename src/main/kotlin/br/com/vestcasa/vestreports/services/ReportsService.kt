package br.com.vestcasa.vestreports.services

import br.com.vestcasa.vestreports.repositories.ReportTypesRepository
import br.com.vestcasa.vestreports.repositories.ReportsRepository
import br.com.vestcasa.vestreports.responseModels.ListAllReportsDataClass
import br.com.vestcasa.vestreports.responseModels.ReportTypeDataClass
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ReportsService(
    private val reportsRepository: ReportsRepository,
    private val reportTypesRepository: ReportTypesRepository,
) {

    fun listAll(
        pageable: Pageable,
        idUser: Int,
    ): Page<ListAllReportsDataClass> {
        print(idUser)

        return reportsRepository.listAll(
            pageable, idUser
        )
    }

    fun findAllTypes(pageable: Pageable): Page<ReportTypeDataClass> {
        return reportTypesRepository.findAll(pageable)
    }
}
