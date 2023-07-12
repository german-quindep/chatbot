package com.example.chatbot.GeneratedPdf.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class PdfModel {
    protected String full_name;
    protected String identified;
    protected String fecha_ingreso;
    protected String cargo;
    protected String fecha_header;

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

    public String transformFecha() {
        // TRANSFORMAR DE FECHA 03-OCT-22 a 03 de octubre del 2022
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
            Date fecha = formatter.parse(fecha_ingreso);
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy", Locale.getDefault());
            fecha_ingreso = formatter2.format(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
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
    //FORMATO FECHA CABECERA QUITO 25 MAYO del 2023
    public String getFecha_header() {
        ZoneId quitoTime = ZoneId.of("America/Guayaquil");
        LocalDate currentDate = LocalDate.now(quitoTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'del' yyyy",
                new Locale("es", "ES"));
        fecha_header = currentDate.format(dateTimeFormatter);
        return fecha_header;
    }
}
