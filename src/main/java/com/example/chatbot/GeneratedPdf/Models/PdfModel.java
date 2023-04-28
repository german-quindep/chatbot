package com.example.chatbot.GeneratedPdf.Models;

public class PdfModel {
    protected String full_name;
    protected String identified;
    protected String fecha_ingreso;
    protected String cargo;

    public PdfModel() {

    }

    public PdfModel(String full_name, String identified, String fecha_ingreso, String cargo) {
        this.full_name = full_name;
        this.identified = identified;
        this.fecha_ingreso = fecha_ingreso;
        this.cargo = cargo;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
