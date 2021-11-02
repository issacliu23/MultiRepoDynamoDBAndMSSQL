package io.guide.localdynamodbandmssql.dynamodb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dynamo")
public class DynamoStudentController {
    @Autowired
    DynamoStudentRepository dynamoStudentRepository;

    @PostMapping("/student")
    public void createStudent(@RequestBody DynamoStudent student){
        dynamoStudentRepository.save(student);
    }

    @GetMapping("/student")
    public List<DynamoStudent> getStudents(){
        return (List<DynamoStudent>) dynamoStudentRepository.findAll();
    }
}
