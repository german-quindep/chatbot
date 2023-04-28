package com.example.chatbot.TelegramBot.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.TelegramBot.Menu.MenuUsers;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.TelegramBot.Model.TBotModel;
import com.example.chatbot.TelegramBot.Service.BotService;

@RestController
@RequestMapping("${api.index}${api.bot.index}")
public class TelegramBotController {
    @Autowired
    private BotService botService;

    @PostMapping("${api.bot.hola}")
    public ResponseBot getHola(@RequestBody TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot(MenuUsers.getMenuPrincipal(),
                "Gracias por usar el bot" + tBotModel.getTipo_mensaje(), null);
        return responseBot;
    }

    @PostMapping("${api.bot.colaborador}")
    public ResponseBot getColaboradorActivo(@RequestBody TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot(MenuUsers.getMenuColaborador(),
                "Ok eres colaborador activo" + tBotModel.getTipo_mensaje(), null);
        return responseBot;
    }

    @PostMapping("${api.bot.certificado-laboral}")
    public ResponseBot getCertificadoLaboral(@RequestBody TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot(MenuUsers.getMenuCertificados(),
                "Ok necesitas un certificado" + tBotModel.getTipo_mensaje(), null);
        return responseBot;
    }

    @PostMapping("${api.bot.certificado-comision}")
    public ResponseBot getComision(@RequestBody TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot(MenuUsers.getMenuPrincipal(),
                "Ok te genero el certificado de comision" + tBotModel.getTipo_mensaje(), null);
        return responseBot;
    }

    @PostMapping("${api.bot.certificado-ingreso}")
    public ResponseBot getIngresos(@RequestBody TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot(MenuUsers.getMenuPrincipal(),
                "Ok te genero el certificado de ingresos" + tBotModel.getTipo_mensaje(), null);
        return responseBot;
    }

    @PostMapping("${api.bot.certificado-sin-ingreso}")
    public ResponseBot getSinIngresos(@RequestBody TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot(MenuUsers.getMenuPrincipal(),
                "Ok te genero el certificado sin ingresos" + tBotModel.getTipo_mensaje(), null);
        return responseBot;
    }

    @PostMapping("${api.bot.certificado-pasante}")
    public ResponseBot getPasante(@RequestBody TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot(MenuUsers.getMenuPrincipal(),
                "Ok te genero el certificado de pasanstes" + tBotModel.getTipo_mensaje(), null);
        return responseBot;
    }

    @PostMapping("${api.bot.vacaciones}")
    public ResponseBot getVacaciones(@RequestBody TBotModel tBotModel) throws IOException {
        return this.botService.sendImg(tBotModel);
    }

    @PostMapping("${api.bot.rol-de-pago}")
    public ResponseBot getRolPagos(@RequestBody TBotModel tBotModel) throws IOException {
        return this.botService.sendImg(tBotModel);
    }

    @PostMapping("/{numero}")
    public ResponseBot getNumero(@PathVariable String numero) {
        return this.botService.validateNumber(numero);
    }
}
