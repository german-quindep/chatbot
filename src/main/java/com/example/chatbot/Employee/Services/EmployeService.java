package com.example.chatbot.Employee.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.Employee.Model.Employee;
import com.example.chatbot.Employee.Repository.EmployeRepo;
import com.example.chatbot.WebService.Models.SalaryEmployeModel;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepo employeRepo;

    public Employee getUser(SalaryEmployeModel employeModel) {
        return employeRepo.getIdentified(employeModel.getIdentificacion());
    }
}
