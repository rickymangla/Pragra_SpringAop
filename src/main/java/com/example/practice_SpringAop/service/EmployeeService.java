package com.example.practice_SpringAop.service;

import com.example.practice_SpringAop.entity.Employee;
import com.example.practice_SpringAop.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
