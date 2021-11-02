package io.guide.localdynamodbandmssql.setup;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import io.guide.localdynamodbandmssql.dynamodb.DynamoStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DynamoDbTableSetUp {
    @Autowired
    DynamoDBMapper dynamoDBMapper;

    @Autowired
    AmazonDynamoDB amazonDynamoDB;

    @PostConstruct
    public void createDynamoDbTables() throws InterruptedException {
        CreateTableRequest req1 = dynamoDBMapper.generateCreateTableRequest(DynamoStudent.class).withProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, req1);
        TableUtils.waitUntilActive(amazonDynamoDB, req1.getTableName());
    }

    @PreDestroy
    public void dropDynamoDbTables()
    {
        DeleteTableRequest req1 = dynamoDBMapper.generateDeleteTableRequest(DynamoStudent.class);
        TableUtils.deleteTableIfExists(amazonDynamoDB, req1);
    }
}
