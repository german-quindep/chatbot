package com.example.chatbot.Users.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.Users.Entity.Usuario;
import com.example.chatbot.Users.Services.UsuarioService;

@RestController
@RequestMapping("${api.index}${api.user.index}")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("${api.user.allUser}")
    public ResponseEntity<?> getUser() {
        return usuarioService.getFindUser();
    }

    @PostMapping("${api.user.create}")
    public ResponseEntity<?> postUser(@RequestBody Usuario usuario) {
        return usuarioService.saveUser(usuario);
    }

}
