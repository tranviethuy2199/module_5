package com.example.repository.EmployeeRepo;

import com.example.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducation_degreeRepository extends JpaRepository<EducationDegree, Integer> {
}
