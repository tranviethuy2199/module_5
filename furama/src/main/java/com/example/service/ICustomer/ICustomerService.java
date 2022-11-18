package com.example.service.ICustomer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    // show danh sách customer
    List<Customer> findAll();

    // tìm customer theo id
    Customer findById(Integer id);

    // lưu khi add customer
    void save(Customer customer);

    // xóa customer
    void remove(Customer customer);

    // phân trang
    Page<Customer> findAll(Pageable pageable);

    //tìm theo tên
    Page<Customer> findCustomerByName(String name ,
                                      String email ,
                                      String type , Pageable pageable);

}
