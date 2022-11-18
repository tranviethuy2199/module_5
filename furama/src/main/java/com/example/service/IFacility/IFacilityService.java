package com.example.service.IFacility;

import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    // show danh sách facility
    List<Facility> findAll();

    // tìm facility theo id
    Facility findById(Integer id);

    // lưu khi add facility
    void save(Facility facility);

    // xóa facility
    void remove(Facility facility);

    // phân trang
    Page<Facility> findAll(Pageable pageable);

//    tìm theo tên
    Page<Facility> findFacilityByName(String name ,
                                      String type , Pageable pageable);
}
