package com.example.chatbot.GeneratedPdf.Models;

public class IngresosModel extends PdfModel {
    private String sueldo_fijo;
    private String sueldo_variable;

    public IngresosModel() {
    }

    public IngresosModel(String full_name, String identified, String fecha_ingreso, String cargo, String sueldo_fijo,
            String sueldo_variable) {
        super(full_name, identified, fecha_ingreso, cargo);
        this.sueldo_fijo = sueldo_fijo;
        this.sueldo_variable = sueldo_variable;
    }

    public String getSueldo_fijo() {
        return sueldo_fijo;
    }

    public void setSueldo_fijo(String sueldo_fijo) {
        this.sueldo_fijo = sueldo_fijo;
    }

    public String getSueldo_variable() {
        return sueldo_variable;
    }

    public void setSueldo_variable(String sueldo_variable) {
        this.sueldo_variable = sueldo_variable;
    }

}
