/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.parte7e9.controller;

import com.pi.parte7e9.data.livrosEntity;
import com.pi.parte7e9.service.livrosService;
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
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    livrosService livrosService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllLivros() {
        List<livrosEntity> livro = livrosService.listarTodosLivros();
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<livrosEntity> getLivroById(@PathVariable Integer id) {
        livrosEntity livro = livrosService.getLivroId(id);
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<livrosEntity> addLivro(@RequestBody livrosEntity livro) {
        var novoLivro = livrosService.adicionarLivro(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<livrosEntity> atualizarLivro(@PathVariable Integer id, @RequestBody livrosEntity livro) {
        var livroAtualizado = livrosService.atualizarStatusLivro(id, livro);
        return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarLivro(@PathVariable Integer id) {
        livrosService.deletarLivro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
