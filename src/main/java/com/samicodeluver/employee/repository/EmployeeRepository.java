package com.samicodeluver.employee.repository;

import com.samicodeluver.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Employee getJoinedEmp( int name);

}
