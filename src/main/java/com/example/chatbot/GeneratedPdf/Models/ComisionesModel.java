package com.example.chatbot.GeneratedPdf.Models;

public class ComisionesModel extends PdfModel {
    private String sueldo_fijo;
    private String comision;

    public ComisionesModel() {
    }

    public ComisionesModel(String full_name, String identified, String fecha_ingreso, String cargo, String sueldo_fijo,
            String comision) {
        super(full_name, identified, fecha_ingreso, cargo);
        this.sueldo_fijo = sueldo_fijo;
        this.comision = comision;
    }

    public String getSueldo_fijo() {
        return sueldo_fijo;
    }

    public void setSueldo_fijo(String sueldo_fijo) {
        this.sueldo_fijo = sueldo_fijo;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }
}
