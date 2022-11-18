package com.example.controller;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.service.IEmployee.IDivisionService;
import com.example.service.IEmployee.IEducation_degreeService;
import com.example.service.IEmployee.IEmployeeService;
import com.example.service.IEmployee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeCustomer {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEducation_degreeService education_degreeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IPositionService positionService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        List<EducationDegree> educationDegrees = education_degreeService.findAll();
        List<Position> positions = positionService.findAll();
        List<Division> divisions = divisionService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("educationDegrees", educationDegrees);
        modelAndView.addObject("positions", positions);
        modelAndView.addObject("divisions", divisions);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/employee/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        List<EducationDegree> educationDegrees = education_degreeService.findAll();
        List<Position> positions = positionService.findAll();
        List<Division> divisions = divisionService.findAll();
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("educationDegrees", educationDegrees);
        modelAndView.addObject("positions", positions);
        modelAndView.addObject("divisions", divisions);
        return modelAndView;
    }

    @PostMapping("/employee/create")
    public ModelAndView createBlog(@ModelAttribute("customer") Employee employee) {
        employeeService.save(employee);
        List<EducationDegree> educationDegrees = education_degreeService.findAll();
        List<Position> positions = positionService.findAll();
        List<Division> divisions = divisionService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("educationDegrees", educationDegrees);
        modelAndView.addObject("positions", positions);
        modelAndView.addObject("divisions", divisions);
        modelAndView.addObject("employees", employee);
        modelAndView.addObject("message", "employee created successfully");
        return modelAndView;
    }

    @GetMapping("/employee/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        List<EducationDegree> educationDegrees = education_degreeService.findAll();
        List<Position> positions = positionService.findAll();
        List<Division> divisions = divisionService.findAll();
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("educationDegrees", educationDegrees);
            modelAndView.addObject("positions", positions);
            modelAndView.addObject("divisions", divisions);
            modelAndView.addObject("employees", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/employee/delete{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        List<EducationDegree> educationDegrees = education_degreeService.findAll();
        List<Position> positions = positionService.findAll();
        List<Division> divisions = divisionService.findAll();
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/delete");
            modelAndView.addObject("educationDegrees", educationDegrees);
            modelAndView.addObject("positions", positions);
            modelAndView.addObject("divisions", divisions);
            modelAndView.addObject("employees", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/employee/delete{id}")
    public String delete(@ModelAttribute("blog") Employee employee) {
        employeeService.remove(employee);
        return "redirect:employee";
    }

    @GetMapping("/employee/view{id}")
    public ModelAndView view(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/employee/find")
    public ModelAndView find(@RequestParam String EmployeeName) {
        List<Employee> employees = employeeService.findEmployeeByName(EmployeeName);
        ModelAndView modelAndView = new ModelAndView("/employee/index");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }


}
