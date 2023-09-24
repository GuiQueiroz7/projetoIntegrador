/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.parte7e9.controller;

import com.pi.parte7e9.data.jogosEntity;
import com.pi.parte7e9.service.jogosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guilh
 */
@RestController
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    jogosService jogosService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllJogos() {
        List<jogosEntity> jogos = jogosService.listarTodosJogos();
        return new ResponseEntity<>(jogos, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<jogosEntity> getJogoById(@PathVariable Integer id) {
        jogosEntity serie = jogosService.getJogoId(id);
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<jogosEntity> addJogo(@RequestBody jogosEntity jogo) {
        var novoJogo = jogosService.adicionarJogo(jogo);
        return new ResponseEntity<>(novoJogo, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<jogosEntity> atualizarJogo(@PathVariable Integer id, @RequestBody jogosEntity jogo) {
        var jogoAtualizado = jogosService.atualizarStatusJogo(id, jogo);
        return new ResponseEntity<>(jogoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarJogo(@PathVariable Integer id) {
        jogosService.deletarJogo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

