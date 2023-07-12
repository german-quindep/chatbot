package com.example.chatbot.Security.interceptor;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.chatbot.Auth.DTO.ConsultAuthBot;
import com.example.chatbot.Auth.Services.AuthBotService;
import com.example.chatbot.Shared.messages.MsgBotError;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class InterceptorSessionBot implements HandlerInterceptor {
    
    @Autowired
    private AuthBotService authBotService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!this.searchTokenTime(request.getHeader("idChatToken"))) {
            String jsonResponse = this.responseBot();
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
            return false;
        }
        return true;
    }

    private String responseBot() throws Exception {
        ResponseBot response = new ResponseBot(null,
                MsgBotError.authOrToken.toString(),
                null);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(response);
        return jsonResponse;
    }

    // CONSULTAR EL TOKEN VALIDO
    private boolean searchTokenTime(String idChatToken) {
        LocalDate dateNow = LocalDate.now();
        Date date1 = Date.valueOf(dateNow);
        ConsultAuthBot authBot = new ConsultAuthBot(idChatToken, date1);
        return authBotService.geAuthBot(authBot);
    }

}
