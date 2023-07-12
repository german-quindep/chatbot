package com.example.chatbot.TelegramBot.Strategy;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.chatbot.Auth.DTO.ConsultAuthBot;
import com.example.chatbot.Auth.Services.AuthBotService;
import com.example.chatbot.BloqUser.Services.BloqUserService;
import com.example.chatbot.Otp.Dto.ConsultOtpCedula;
import com.example.chatbot.Otp.Service.OtpService;
import com.example.chatbot.Shared.helpers.ReplaceSpace;
import com.example.chatbot.TelegramBot.Menu.MenuUsers;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.WebService.Models.SalaryEmployeModel;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Component
public class CedulaBot implements IBotStrategy {
  private static String API_URL = "http://localhost:8081/employee/getUser";

  @Autowired
  private OtpService otp;
  @Autowired
  private AuthBotService authBotService;
  @Autowired
  private BloqUserService bloqUserService;

  @Override
  public BotStrategyRegex getTypeBot() {
    return BotStrategyRegex.CEDULA;
  }

  @Override
  public ResponseBot executeAlgoritmo(String numero) {
    ReplaceSpace replace = new ReplaceSpace(numero);
    String text[] = replace.replaceComaList();
    ResponseBot responseBot = new ResponseBot();
    String result = this.getResponse(text[0]);
    // SI NO EXISTE EL USUARIO
    if (result == null) {
      String mensaje = bloqUserService.saveBloqUser(text[1]); //INTETOS DE USUARIO PARA BLOQUEARLO
      responseBot.setReplyKeyboardMarkup(MenuUsers.getMenuPrincipal());
      responseBot.setRespuesta(mensaje);
      return responseBot;
    }
    this.otpUpdateOtp(text[1], text[0]); // CUANDO EL USUARIO ESCRIBE DOS CEDULA
    // SI ES EL USUARIO DE DHO
    if (text[0].equals("0930111059")) {
      responseBot.setReplyKeyboardMarkup(MenuUsers.getMenuDHO());
      responseBot.setRespuesta(otp.saveOtp(text[1], text[0]));
      return responseBot;
    }
    // SI ES UN COLABORADOR
    responseBot.setReplyKeyboardMarkup(MenuUsers.getMenuAuthCheck());
    responseBot.setRespuesta(otp.saveOtp(text[1], text[0]));
    return responseBot;
  }

  // ELIMINAR EL TOKEN QUE YA SE GENERO ANTERIORMENTE LUEGO DE INGRESAR EL OTP
  private void deleteToken(String numero) {
    LocalDate dateNow = LocalDate.now();
    Date date1 = Date.valueOf(dateNow);
    ConsultAuthBot consult = new ConsultAuthBot(numero, date1);
    authBotService.deleteToken(consult);
  }

  // buscar si el usuario existe y actualizar si tiene un otp generado
  private void otpUpdateOtp(String idChat, String identificacion) {
    ConsultOtpCedula otpCedula = new ConsultOtpCedula(idChat, identificacion);
    otp.getOtpChatUpdateIdentify(otpCedula);
    this.deleteToken(idChat);
  }

  // Buscar el usuario
  private String getResponse(String cedula) {
    SalaryEmployeModel salaryModel = new SalaryEmployeModel("consultarRol", cedula, "2023", "02");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<SalaryEmployeModel> requestEntity = new HttpEntity<>(salaryModel, headers);
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.postForObject(API_URL, requestEntity, String.class);
  }
}
