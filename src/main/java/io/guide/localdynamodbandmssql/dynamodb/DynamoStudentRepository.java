package io.guide.localdynamodbandmssql.dynamodb;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface DynamoStudentRepository extends CrudRepository<DynamoStudent, String> {
    List<DynamoStudent> findByLastName(String lastName);
    List<DynamoStudent> findByFirstName(String firstName);
}
