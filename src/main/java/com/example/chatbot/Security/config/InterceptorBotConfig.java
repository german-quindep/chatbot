package com.example.chatbot.Security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.chatbot.Security.interceptor.InterceptorBloqUser;
import com.example.chatbot.Security.interceptor.InterceptorDhoSession;
import com.example.chatbot.Security.interceptor.InterceptorSessionBot;

@Configuration
public class InterceptorBotConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorSessionBot miInterceptor;
    @Autowired
    private InterceptorDhoSession dhoSession;
    @Autowired
    private InterceptorBloqUser bloqUser;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // SESION DE USUARIO
        registry.addInterceptor(miInterceptor)
                .addPathPatterns("/bot/vacaciones",
                        "/bot/colaborador-activo",
                        "/bot/certificados",
                        "/bot/certificado-con-ingresos",
                        "/bot/certificado-sin-ingresos",
                        "/bot/certificado-con-comision",
                        "/bot/roles-de-pago",
                        "/bot/certificado-de-pasantes",
                        "/bot/pdf/**");
        // SESION DE DHO
        registry.addInterceptor(dhoSession)
                .addPathPatterns("/bot/ex-colaborador");
        // BLOQUEO DE USUARIO INTERCEPTOR
        registry.addInterceptor(bloqUser)
                .addPathPatterns("/bot/hola","/bot/vacaciones",
                        "/bot/colaborador-activo",
                        "/bot/certificados",
                        "/bot/certificado-con-ingresos",
                        "/bot/certificado-sin-ingresos",
                        "/bot/certificado-con-comision",
                        "/bot/roles-de-pago",
                        "/bot/certificado-de-pasantes",
                        "/bot/pdf/**",
                        "/bot/ex-colaborador");
    }
}
