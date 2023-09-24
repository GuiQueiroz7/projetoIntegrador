/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.atividade3PI.service;

import com.trabalho.atividade3PI.data.livrosEntity;
import com.trabalho.atividade3PI.data.livrosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilh
 */
@Service
public class livrosService {

    @Autowired
    livrosRepository livrosRepository;

    public livrosEntity adicionarLivro(livrosEntity livro) {
        livro.setId(null);
        livrosRepository.save(livro);
        return livro;
    }

    public livrosEntity atualizarStatusLivro(Integer livroId, livrosEntity livroRequest) {
        livrosEntity livro = getLivroId(livroId);
        livro.setStatus(livroRequest.getStatus());
        livrosRepository.save(livro);
        return livro;
    }

    public livrosEntity getLivroId(Integer livroId) {
        return livrosRepository.findById(livroId).orElse(null);
    }

    public List<livrosEntity> listarTodosLivros() {
        return livrosRepository.findAll();
    }

    public void deletarLivro(Integer livroId) {
        livrosEntity livro = getLivroId(livroId);
        livrosRepository.deleteById(livro.getId());
    }
}
