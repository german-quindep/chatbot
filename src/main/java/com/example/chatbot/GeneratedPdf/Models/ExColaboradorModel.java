package com.example.chatbot.GeneratedPdf.Models;

public class ExColaboradorModel extends PdfModel {
    private String fecha_final;

    public ExColaboradorModel() {
    }

    public ExColaboradorModel(String full_name, String identified, String fecha_ingreso, String cargo) {
        super(full_name, identified, fecha_ingreso, cargo);
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

}
