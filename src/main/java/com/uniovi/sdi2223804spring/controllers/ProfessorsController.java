package com.uniovi.sdi2223804spring.controllers;

import com.uniovi.sdi2223804spring.entities.Professor;
import com.uniovi.sdi2223804spring.sevices.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;

    @RequestMapping(value="professor/add" , method=RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor){
        professorsService.addProfessor(professor);
        return "Ok";
    }

    @RequestMapping("professor/add")
    public String getProfessor(){
        return "nuevo formulario";
    }

    @RequestMapping("professor/list")
    public String getList(){
        return professorsService.getProfessors().toString();
    }

    @RequestMapping("professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorsService.deleteProfessor(id);
        return "Ok";
    }

    @RequestMapping("professor/details/{id}")
    public String getDetail(@PathVariable Long id){
        return professorsService.getProfessor(id).toString();
    }


}
