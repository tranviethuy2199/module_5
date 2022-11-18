package com.example.service.impl.employee;

import com.example.model.employee.EducationDegree;
import com.example.repository.EmployeeRepo.IEducation_degreeRepository;
import com.example.service.IEmployee.IEducation_degreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Education_degreeService implements IEducation_degreeService {
    @Autowired
    private IEducation_degreeRepository education_degreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return education_degreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return education_degreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        education_degreeRepository.save(educationDegree);
    }

    @Override
    public void remove(EducationDegree educationDegree) {
        education_degreeRepository.delete(educationDegree);
    }
}
