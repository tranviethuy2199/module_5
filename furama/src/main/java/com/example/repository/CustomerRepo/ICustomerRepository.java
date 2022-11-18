package com.example.repository.CustomerRepo;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer , Integer> {
    @Query(value = "select c.* from `customer` c  join `customer_type` ct " +
            "on c.customer_id = ct.id " +
            "where c.name like %:name% " +
            "and c.email like %:email% " +
            "and ct.name like %:type% " +
            "and status = 1",
            nativeQuery = true)
    Page<Customer> findCustomerByName(@Param("name") String name,
                                      @Param("email") String email,
                                      @Param("type") String type , Pageable pageable);

    @Query(value = "select * from customer where status = 1",
            nativeQuery = true)
    Page<Customer> findAll(
            Pageable pageable);

//

//    Page<Customer> findAll(Pageable pageable);

}
