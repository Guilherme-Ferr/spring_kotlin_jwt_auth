package br.com.vestcasa.vestreports.repositories

import br.com.vestcasa.vestreports.responseModels.ListAllReportsDataClass
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ReportsRepository : JpaRepository<ListAllReportsDataClass, Int> {

    @Query(nativeQuery = true, value = "select r.id_report, r.name, r.description, r.embedded_id, r.image from vest_reports.report_types rt inner join vest_reports.reports r on rt.id_report_type = r.id_report_type inner join vest_reports.user_types_reports utr on r.id_report = utr.id_report inner join vest_reports.user_types ut on utr.id_user_type = ut.id_user_type inner join vest_reports.users u on ut.id_user_type = u.id_user_type where rt.name = 'Estoque' and r.name like '%es%' and rt.finished_at is null and r.finished_at is null and utr.finished_at is null and ut.finished_at is null and u.finished_at is null and u.id_user = :id_user")
    fun listAll(pageable: Pageable, id_user: Int): Page<ListAllReportsDataClass>
}
