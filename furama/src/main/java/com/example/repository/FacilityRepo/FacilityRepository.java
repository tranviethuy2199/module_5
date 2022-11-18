package com.example.repository.FacilityRepo;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(
            value = "select * from facility " +
                    "where name like %:name%" +
                    " and facility_type_id like %:type% " +
                    "and status = 1",
            nativeQuery = true
    )
    Page<Facility> findFacilityByName(@Param("name") String name,
                                      @Param("type") String type,
                                      Pageable pageable);


    @Query(value = "select * from facility where status = 1" , nativeQuery = true)
    Page<Facility> findAll(Pageable pageable);
}
