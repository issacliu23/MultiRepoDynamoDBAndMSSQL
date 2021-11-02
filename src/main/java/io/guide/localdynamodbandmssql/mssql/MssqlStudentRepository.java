package io.guide.localdynamodbandmssql.mssql;

import org.springframework.data.repository.CrudRepository;

public interface MssqlStudentRepository extends CrudRepository<MssqlStudent, String> {
}
