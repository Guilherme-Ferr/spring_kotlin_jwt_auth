package br.com.vestcasa.vestreports.repositories

import br.com.vestcasa.vestreports.models.ReportType
import org.springframework.data.repository.CrudRepository

interface ReportTypesRepository : CrudRepository<ReportType, Int> {}
