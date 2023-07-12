package com.example.chatbot.GeneratedPdf.Helpers;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.example.chatbot.GeneratedPdf.Models.ComisionesModel;
import com.example.chatbot.GeneratedPdf.Models.IngresosModel;
import com.example.chatbot.GeneratedPdf.Models.PdfModel;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Component
public class JsonReplace {
    @Value("${urlApi}${api.index}${api.bot.index}/pdf/") 
    private String API_URL/* ="http://localhost:8081/api/bot/pdf/" */ ;
    private PdfModel pdfModel;
    private IngresosModel ingresosModel;
    private ComisionesModel comisionesModel;

    public <T> String getModel(String url, T model) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> requestEntity = new HttpEntity<>(model, headers);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(API_URL + url, requestEntity, String.class);
        return response;
    }

    public String getPdfModel(String jsonStr) {
        JSONObject jsonObj = new JSONObject(jsonStr);
        this.pdfModel = new PdfModel();
        this.pdfModel.setFull_name(jsonObj.getString("full_name"));
        this.pdfModel.setFecha_ingreso(jsonObj.getString("fecha_ingreso"));
        this.pdfModel.setCargo(jsonObj.getString("cargo"));
        this.pdfModel.setIdentified(jsonObj.getString("identified"));
        this.pdfModel.getFecha_header();
        this.pdfModel.transformFecha();
        return getModel("certificado-sin-ingresos", pdfModel);
    }

    public String getIngresosModel(String jsonStr) {
        JSONObject jsonObj = new JSONObject(jsonStr);
        this.ingresosModel = new IngresosModel();
        this.ingresosModel.setFull_name(jsonObj.getString("full_name"));
        this.ingresosModel.setFecha_ingreso(jsonObj.getString("fecha_ingreso"));
        this.ingresosModel.setCargo(jsonObj.getString("cargo"));
        this.ingresosModel.setIdentified(jsonObj.getString("identified"));
        this.ingresosModel.setSueldo_fijo(jsonObj.getString("sueldo_fijo"));
        this.ingresosModel.setSueldo_variable(jsonObj.getString("sueldo_variable"));
        this.ingresosModel.getFecha_header();
        this.ingresosModel.transformFecha();
        return getModel("certificado-con-ingresos", ingresosModel);
    }

    public String getComisionModel(String jsonStr) {
        JSONObject jsonObj = new JSONObject(jsonStr);
        this.comisionesModel = new ComisionesModel();
        this.comisionesModel.setFull_name(jsonObj.getString("full_name"));
        this.comisionesModel.setFecha_ingreso(jsonObj.getString("fecha_ingreso"));
        this.comisionesModel.setCargo(jsonObj.getString("cargo"));
        this.comisionesModel.setIdentified(jsonObj.getString("identified"));
        this.comisionesModel.setSueldo_fijo(jsonObj.getString("sueldo_fijo"));
        this.comisionesModel.setComision(jsonObj.getString("comisiones"));
        this.comisionesModel.getFecha_header();
        this.comisionesModel.transformFecha();
        return getModel("certificado-con-comision", comisionesModel);
    }
}
