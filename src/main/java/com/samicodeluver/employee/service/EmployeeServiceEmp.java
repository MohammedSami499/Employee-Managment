package com.samicodeluver.employee.service;

import com.samicodeluver.employee.entity.Employee;
import com.samicodeluver.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceEmp implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        Employee emp = null;
        if(employee.isPresent()){
            emp = employee.get();
        }else{
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return emp;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo , int pageSize, String sortField, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending()
                :Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo-1 , pageSize , sort );
        return employeeRepository.findAll(pageable);

    }

//    @Override
//    public void updateEmployee(Employee employee) {
//        employeeRepository.updateEmployee(employee);
//    }
}
