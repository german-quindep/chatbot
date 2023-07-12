package com.example.chatbot.Security.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.chatbot.BloqUser.Services.BloqUserService;
import com.example.chatbot.Shared.messages.MsgBotError;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class InterceptorBloqUser implements HandlerInterceptor {
    @Autowired
    private BloqUserService bloqUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!this.searchUserBloq(request.getHeader("idChatToken"))) {
            String jsonResponse = this.responseBot();
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
            return false;
        }
        return true;
    }

    // PARA ENVIAR CUANDO EL USUARIO ESTE BLOQUEADO
    private String responseBot() throws Exception {
        ResponseBot response = new ResponseBot(null,
                MsgBotError.bloqUserGet.toString(),
                null);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(response);
        return jsonResponse;
    }

    // CONSULTAR EL TOKEN VALIDO
    private boolean searchUserBloq(String idChat) {
        return bloqUserService.getUserbloq(idChat);
    }

}
