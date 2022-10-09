package com.samicodeluver.employee.service;

import com.samicodeluver.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> allEmployee();
    public void addEmployee(Employee employee);
    public Employee getEmployeeById(Long id);
    public void deleteEmployee(Long id);
    public Page<Employee> findPaginated(int pageNo , int pageSize, String sortField, String sortDirection);
//    public void updateEmployee(Employee employee);

}
