package com.example.service.IEmployee;

import com.example.model.employee.EducationDegree;

import java.util.List;

public interface IEducation_degreeService {
    List<EducationDegree> findAll();

    EducationDegree findById(int id);

    void save(EducationDegree educationDegree);

    void remove(EducationDegree educationDegree);
}
