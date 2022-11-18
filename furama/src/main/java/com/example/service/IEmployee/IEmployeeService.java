package com.example.service.IEmployee;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    // show danh sách employee
    List<Employee> findAll();

    // tìm employee theo id
    Employee findById(Integer id);

    // lưu khi add employee
    void save(Employee employee);

    // xóa employee
    void remove(Employee employee);

    // phân trang
    Page<Employee> findAll(Pageable pageable);

    //tìm theo tên
    List<Employee> findEmployeeByName(String EmployeeName);
}
