package io.guide.localdynamodbandmssql.mssql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mssql")
public class MssqlStudentController {
    @Autowired
    MssqlStudentRepository mssqlStudentRepository;

    @PostMapping("/student")
    public void createStudent(@RequestBody MssqlStudent student){
        mssqlStudentRepository.save(student);
    }

    @GetMapping("/student")
    public List<MssqlStudent> getStudents(){
        return (List<MssqlStudent>) mssqlStudentRepository.findAll();
    }
}
