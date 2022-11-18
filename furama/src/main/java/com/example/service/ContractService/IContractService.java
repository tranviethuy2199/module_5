package com.example.service.ContractService;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    // show danh sách contract
    List<Contract> findAll();

    // tìm contract theo id
    Contract findById(Integer id);

    //hiển thị danh sách dịch vụ đi kèm theo contract id
    Contract showAttachFacilityById(int id);

    // lưu khi add contract
    void save(Contract contract);

    // xóa contract
    void remove(Contract contract);

    // phân trang
    Page<Contract> findAll(Pageable pageable);



}
