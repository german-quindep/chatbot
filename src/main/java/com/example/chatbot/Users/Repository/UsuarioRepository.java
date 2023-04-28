package com.example.chatbot.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.Users.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
