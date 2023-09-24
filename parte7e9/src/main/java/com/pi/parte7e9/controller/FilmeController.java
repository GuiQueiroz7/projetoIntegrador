/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.parte7e9.controller;

import com.pi.parte7e9.data.filmesEntity;
import com.pi.parte7e9.service.filmesService;
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
@RequestMapping("/filme")
public class FilmeController {
    @Autowired
    filmesService filmesService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllFilmes() {
        List<filmesEntity> filmes = filmesService.listarTodosFilmes();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<filmesEntity> getFilmesById(@PathVariable Integer id) {
        filmesEntity filme = filmesService.getFilmeId(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<filmesEntity> addFilme(@RequestBody filmesEntity filme) {
        var novoFilme = filmesService.adicionarFilme(filme);
        return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<filmesEntity> atualizarFilme(@PathVariable Integer id, @RequestBody filmesEntity filme) {
        var filmeAtualizado = filmesService.atualizarStatusFilme(id, filme);
        return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarFilme(@PathVariable Integer id) {
        filmesService.deletarFilme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
