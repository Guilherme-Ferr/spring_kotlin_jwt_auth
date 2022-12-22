package br.com.vestcasa.vestreports.repositories

import br.com.vestcasa.vestreports.responseModels.ReportTypeDataClass
import org.springframework.data.jpa.repository.JpaRepository

interface ReportTypesRepository : JpaRepository<ReportTypeDataClass, Int> {}
