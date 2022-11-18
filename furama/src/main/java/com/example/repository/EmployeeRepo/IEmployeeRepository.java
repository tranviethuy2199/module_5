package com.example.repository.EmployeeRepo;

import com.example.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee , Integer> {
    @Query(value = "select * from Employee where name like %:keyword%", nativeQuery = true)
    List<Employee> findEmployeeByName(@Param("keyword") String EmployeeName);
}
