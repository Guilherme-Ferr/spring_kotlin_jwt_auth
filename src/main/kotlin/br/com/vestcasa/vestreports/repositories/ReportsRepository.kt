package br.com.vestcasa.vestreports.repositories

import br.com.vestcasa.vestreports.models.Report
import org.springframework.data.repository.CrudRepository

interface ReportsRepository : CrudRepository<Report, Int> {}
