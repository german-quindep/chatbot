package com.example.chatbot.TelegramBot.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.chatbot.Shared.helpers.ReplaceSpace;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.TelegramBot.Model.TBotModel;

public class ConsumeApi {
    @Value("${urlApi}")
    private String urlApi;
    private ReplaceSpace replaceSpace;
    private String API_URL = "http://localhost:8081" + "/api/bot/";

    public ConsumeApi() {

    }

    public ResponseBot getSolicitud(String mensaje) {
        TBotModel tBotModel = new TBotModel(mensaje);
        this.replaceSpace = new ReplaceSpace(mensaje);
        String transformMsj = this.replaceSpace.replaceText();
        this.API_URL = this.API_URL + transformMsj;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TBotModel> requestEntity = new HttpEntity<>(tBotModel, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseBot response = restTemplate.postForObject(API_URL, requestEntity, ResponseBot.class);
        return response;
    }

}
