package com.example.chatbot.TelegramBot.helpers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.chatbot.Shared.helpers.ReplaceSpace;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.TelegramBot.Model.TBotModel;

public class ConsumeApi {
    private ReplaceSpace replaceSpace;
    /* private String API_URL = "http://localhost:8081" + "/bot/"; */
    private String API_URL;

    public ConsumeApi(String apiUrl) {
        this.API_URL = apiUrl;
    }

    public ResponseBot getSolicitud(String mensaje, Long idChat) {
        TBotModel tBotModel = new TBotModel(mensaje, idChat.toString());
        this.replaceSpace = new ReplaceSpace(mensaje);
        String transformMsj = this.replaceSpace.replaceText();
        this.API_URL = this.API_URL + transformMsj;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("idChatToken", idChat.toString());
        HttpEntity<TBotModel> requestEntity = new HttpEntity<>(tBotModel, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseBot response = restTemplate.postForObject(API_URL, requestEntity, ResponseBot.class);
        return response;
    }
}
