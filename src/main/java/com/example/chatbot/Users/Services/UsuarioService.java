package com.example.chatbot.Users.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.chatbot.Shared.Response.Model.Response;
import com.example.chatbot.Shared.Validation.ValidateCampo;
import com.example.chatbot.Shared.Validation.ValidateModel;
import com.example.chatbot.Users.Entity.Usuario;
import com.example.chatbot.Users.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public ValidateCampo validateCampo = new ValidateCampo();

    public ResponseEntity<?> saveUser(Usuario usuario) {
        Response<Usuario, List<ValidateModel>> respo = new Response<>();
        this.validateCampo.inserErrorString("email", usuario.getEmail());
        if (this.validateCampo.getListError().isEmpty()) {
            usuarioRepository.save(usuario);
            respo.ResponseSuccess("ok", 200, usuario);
            return ResponseEntity.status(HttpStatus.OK.value()).body(respo);
        } else {
            respo.ResponseError("error", 404, this.validateCampo.getListError());
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(respo);
        }
    }

    public ResponseEntity<?> getFindUser() {
        Response<List<Usuario>, String> respo = new Response<>();
        List<Usuario> userList = usuarioRepository.findAll();
        if (userList.isEmpty()) {
            respo.ResponseError("error", 404, "No existen datos en la base de datos");
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(respo);

        } else {
            respo.ResponseSuccess("ok", 200, userList);
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(respo);

        }
    }

}
