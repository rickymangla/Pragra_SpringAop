package com.example.practice_SpringAop.api;

import com.example.practice_SpringAop.entity.Employee;
import com.example.practice_SpringAop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        ResponseEntity<Employee> responseEntity = null;
        responseEntity = ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(employeeService.addEmployee(employee));
        return responseEntity;
    }
}
