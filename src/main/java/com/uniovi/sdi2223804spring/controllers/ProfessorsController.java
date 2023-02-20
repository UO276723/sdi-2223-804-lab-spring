package com.uniovi.sdi2223804spring.controllers;

import com.uniovi.sdi2223804spring.entities.Professor;
import com.uniovi.sdi2223804spring.services.ProfessorsService;
import com.uniovi.sdi2223804spring.validators.ProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;

    @Autowired
    private ProfessorValidator professorValidator;

    @RequestMapping(value="/professor/add" , method=RequestMethod.POST)
    public String setProfessor(@Validated Professor professor, BindingResult result, Model model){
        professorValidator.validate(professor, result);
        if (result.hasErrors()){
            model.addAttribute(professor);
            return "professor/add";
        }
        professorsService.addProfessor(professor);
        return "redirect:/professor/list";
    }

    @RequestMapping(value="/professor/add", method = RequestMethod.GET)
    public String getProfessor(Model model){
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }

    @RequestMapping("/professor/list")
    public String getList(Model model){
        model.addAttribute("professorList", professorsService.getProfessors());
        return "professor/list";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorsService.deleteProfessor(id);
        return "redirect:/professor/list";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id){
        model.addAttribute("professor", professorsService.getProfessor(id));
        return "professor/details";
    }


}
