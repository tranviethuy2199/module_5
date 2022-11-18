package com.example.controller;

import com.example.model.facility.Facility;
import com.example.model.facility.RentType;
import com.example.model.facility.FacilityType;
import com.example.service.IFacility.IFacilityService;
import com.example.service.IFacility.IRentTypeService;
import com.example.service.IFacility.IStandardRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IStandardRoomService standardRoomService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 3)
                                             Pageable pageable) {
        Page<Facility> facilities = facilityService.findAll(pageable);
        List<FacilityType> facilityTypes = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        Facility facilityEmpty = new Facility();
        ModelAndView modelAndView = new ModelAndView("/facility/list");
        modelAndView.addObject("facilities", facilities);
        modelAndView.addObject("facilityEmpty", facilityEmpty);
        modelAndView.addObject("facilityTypes", facilityTypes);
        modelAndView.addObject("rentTypes", rentTypes);
        return modelAndView;
    }

    @GetMapping("/facility/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/facility/create");
        List<FacilityType> facilityTypes = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        modelAndView.addObject("facilities", new Facility());
        modelAndView.addObject("facilityTypes", facilityTypes);
        modelAndView.addObject("rentTypes", rentTypes);
        return modelAndView;
    }

    @PostMapping("/facility/create")
    public ModelAndView createBlog(@Validated  @ModelAttribute("facility") Facility facility , BindingResult bindingResult) {
        new Facility().validate(facility, bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/facility/create");
            return modelAndView;
        }
        facilityService.save(facility);
        List<FacilityType> facilityTypes = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/facility/create");
        modelAndView.addObject("facilities", facility);
        modelAndView.addObject("facilityTypes", facilityTypes);
        modelAndView.addObject("rentTypes", rentTypes);
        modelAndView.addObject("message", "facility created successfully");
        return modelAndView;
    }

    @GetMapping("/edit")
    public String showUpdateForm(@ModelAttribute("facilityEmpty") Facility facility,
                                       RedirectAttributes redirectAttributes) {
        facility = facilityService.findById(facility.getId());
        List<FacilityType> facilityTypes = standardRoomService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        facilityService.save(facility);
        ModelAndView modelAndView = new ModelAndView("/facility/edit");
        modelAndView.addObject("facilities", facility);
        modelAndView.addObject("facilityTypes", facilityTypes);
        modelAndView.addObject("rentTypes", rentTypes);
        redirectAttributes.addFlashAttribute("message", "update " + facility.getFacilityType() + "OK!");
    return "redirect:/facility";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam int id ) {
        Facility facilityDelete = facilityService.findById(id);
        facilityDelete.setStatus(0);
        facilityService.save(facilityDelete);
        return "redirect:/facility";
    }

    @GetMapping("/find123")
    public ModelAndView find(@RequestParam(value = "searchName", required = false) String searchName,
                             @RequestParam(value = "type", required = false) String type,
                             @PageableDefault(value = 3) Pageable pageable , Model model) {

        if (searchName == null) {
            searchName = "";
        }

        if (type == null) {
            type = "";
        }
        Page<Facility> facilities = facilityService.findFacilityByName(searchName, type, pageable);
        List<FacilityType> facilityTypes = standardRoomService.findAll();
        ModelAndView modelAndView = new ModelAndView("/facility/list");
        modelAndView.addObject("facilities", facilities);
        modelAndView.addObject("facilityTypes", facilityTypes);
        modelAndView.addObject("searchName", searchName);
        modelAndView.addObject("type", type);
        modelAndView.addObject("facilityEmpty", new Facility());
        model.addAttribute("name" , searchName);
        return modelAndView;

    }

}
