package com.example.chatbot.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.Shared.Response.Model.Response;
import com.example.chatbot.Shared.Validation.ValidateModel;
import com.example.chatbot.Users.Entity.Usuario;
import com.example.chatbot.Users.Services.UsuarioService;

@RestController
@RequestMapping("${api.index}${api.user.index}")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("${api.user.allUser}")
    public Response<List<Usuario>, String> getUser() {
        return usuarioService.getFindUser();
    }

    @PostMapping("${api.user.create}")
    public Response<Usuario, List<ValidateModel>> postUser(@RequestBody Usuario usuario) {
        return usuarioService.saveUser(usuario);
    }

}
