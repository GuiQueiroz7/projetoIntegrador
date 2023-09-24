/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.atividade3PI.service;

import com.trabalho.atividade3PI.data.usuarioEntity;
import com.trabalho.atividade3PI.data.usuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilh
 */
@Service
public class usuariosService {

    @Autowired
    usuarioRepository usuarioRepository;

    public usuarioEntity adicionarUsuario(usuarioEntity usuario) {
        usuario.setId(null);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public usuarioEntity getUsuarioId(Integer usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    public List<usuarioEntity> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }
}
