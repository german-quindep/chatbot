package com.example.chatbot.WebService;

import org.springframework.web.client.RestTemplate;

import com.example.chatbot.GeneratedPdf.Entity.PdfUser;
import com.example.chatbot.GeneratedPdf.Services.PdfService;
import com.example.chatbot.GeneratedPdf.Strategy.TypePdf;
import com.example.chatbot.GeneratedPdf.Strategy.ValidateTypePdf;
import com.example.chatbot.GeneratedPdf.Strategy.Context.StrategyPdfData;
import com.example.chatbot.Otp.Service.OtpService;
import com.example.chatbot.WebService.Models.SalaryEmployeModel;

import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class ConsumerWS {
    @Autowired
    private StrategyPdfData strategyPdfData;
    private SalaryEmployeModel salaryEmployeModel;
    private static String API_URL = "http://localhost:8081/employee/getUser";
    @Autowired
    private OtpService otpService;
    @Autowired
    private PdfService pdfService;

    private String getResponse(SalaryEmployeModel salaryEmployeModel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SalaryEmployeModel> requestEntity = new HttpEntity<>(salaryEmployeModel, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(API_URL, requestEntity, String.class);
    }

    public String getFindUserPdf(String idChat, String tipo) {
        String urlData = "";
        String cedula = otpService.getIdChatOtpUser(idChat);
        this.salaryEmployeModel = new SalaryEmployeModel("consultarRol", cedula, "2023", "02");
        // recorro la lista de enum que tengo para validar con la peticion del usuario
        for (ValidateTypePdf regex : ValidateTypePdf.values()) {
            if (regex.validate(tipo)) { // busco si es identica a lo que estoy buscando
                TypePdf typePdf = TypePdf.valueOf(regex.getmessageType()); // retorno el valor a generar
                String jsonData = this.getResponse(this.salaryEmployeModel); // envio el body a buscar
                String fileUrl = strategyPdfData.executePdf(typePdf, jsonData); // busco el tipo de certificado a generar
                urlData = this.savePdfUrl(idChat, fileUrl);
                break;
            }
        }
        return urlData;
    }

    private String savePdfUrl(String idChat, String urlData) {
        PdfUser model = new PdfUser();
        model.setIdChat(idChat);
        model.setUrlArchive(urlData);
        return pdfService.savePdfUser(model).getUrlArchive();
    }
}
