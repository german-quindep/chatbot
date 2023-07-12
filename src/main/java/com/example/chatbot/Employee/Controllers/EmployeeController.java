package com.example.chatbot.Employee.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.Employee.Model.Employee;
import com.example.chatbot.Employee.Services.EmployeService;
import com.example.chatbot.WebService.Models.SalaryEmployeModel;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeService employeService;

    @PostMapping("/getUser")
    public Employee getDataUser(@RequestBody SalaryEmployeModel employeModel) {
        return employeService.getUser(employeModel);
    }
}
