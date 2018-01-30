package org.launchcode.project.trainingapp.controllers;

import org.launchcode.project.trainingapp.models.Doctor;
import org.launchcode.project.trainingapp.models.data.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("doctors", doctorDao.findAll());
        model.addAttribute("title", "Current Doctors");

        return "doctor/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddDoctorForm(Model model) {
        model.addAttribute("title", "Add New Doctor");
        model.addAttribute(new Doctor());
//        model.addAttribute("clinic", clinicDao.findAll());
        return "doctor/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddDoctorForm(@ModelAttribute @Valid Doctor newDoctor,
                                       Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Doctor");
            return "doctor/add";
        }
        doctorDao.save(newDoctor);

        return "redirect:";

    }

}