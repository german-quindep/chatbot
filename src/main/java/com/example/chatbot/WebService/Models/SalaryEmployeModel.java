package com.example.chatbot.WebService.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryEmployeModel {
    private String opcion;
    private String identificacion;
    private String anio;
    private String mes;

}
