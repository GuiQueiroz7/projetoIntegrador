/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.atividade3PI.controller;

import com.trabalho.atividade3PI.data.usuarioEntity;
import com.trabalho.atividade3PI.service.usuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guilh
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    usuariosService userService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllUsers() {
        List<usuarioEntity> users = userService.listarTodosUsuarios();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<usuarioEntity> getUserById(@PathVariable Integer id) {
        usuarioEntity user = userService.getUsuarioId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<usuarioEntity> addUser(@RequestBody usuarioEntity user) {
        var novoUsuario = userService.adicionarUsuario(user);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }
}
