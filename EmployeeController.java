package com.ems.controller;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO dao;

    @GetMapping("/")
    public String listEmployees(Model model) {
        model.addAttribute("list", dao.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("emp", new Employee());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee emp) {
        dao.save(emp);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("emp", dao.getById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/";
    }
}
