package com.samicodeluver.employee.service;

import com.samicodeluver.employee.entity.Employee;
import com.samicodeluver.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeRepository repository;

//    @Test
//    public void addAll(){
//        Employee employee = Employee.builder()
//                .firstName("Ahmed")
//                .lastName("Atteya")
//                .email("atteyaAhmed@gmail.com")
//                .address("Ahebin Elkohm")
//                .build();
//        repository.save(employee);
//    }

}