package com.example.chatbot.Users.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Response<Usuario, List<ValidateModel>> saveUser(Usuario usuario) {
        Response<Usuario, List<ValidateModel>> respo = new Response<>();
        this.validateCampo.inserErrorString("email", usuario.getEmail());
        if (this.validateCampo.getListError().isEmpty()) {
            usuarioRepository.save(usuario);
            respo.ResponseSuccess("ok", 200, usuario);
            return respo;
        } else {
            respo.ResponseError("error", 400, this.validateCampo.getListError());
            return respo;
        }
    }

    public Response<List<Usuario>, String> getFindUser() {
        Response<List<Usuario>, String> respo = new Response<>();
        List<Usuario> userList = usuarioRepository.findAll();
        if (userList.isEmpty()) {
            respo.ResponseError("error", 400, "No existen datos en la base de datos");
            return respo;
        } else {
            respo.ResponseSuccess("ok", 200, userList);
            return respo;
        }
    }

}
