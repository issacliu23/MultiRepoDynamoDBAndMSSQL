package io.guide.localdynamodbandmssql;

import io.guide.localdynamodbandmssql.dynamodb.DynamoStudentRepository;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
				classes = {DynamoStudentRepository.class})
})
@EnableDynamoDBRepositories(basePackageClasses = {DynamoStudentRepository.class})
public class LocalDynamodbAndMssqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalDynamodbAndMssqlApplication.class, args);
	}

}
