package org.alexbezverkhniy.ractivereports.core.repositories;

import org.alexbezverkhniy.ractivereports.core.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex Bezverkhniy on 10/9/14.
 */
@RepositoryRestResource(collectionResourceRel = "reports", path = "reports", exported = true)
public interface ReportRepository extends PagingAndSortingRepository<Report, Long>, CrudRepository<Report, Long>{
}
