/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.atividade3PI.service;

import com.trabalho.atividade3PI.data.filmesEntity;
import com.trabalho.atividade3PI.data.filmesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilh
 */
@Service
public class filmesService {

    @Autowired
    filmesRepository filmesRepository;

    public filmesEntity adicionarFilme(filmesEntity filme) {
        filme.setId(null);
        filmesRepository.save(filme);
        return filme;
    }

    public filmesEntity atualizarStatusFilme(Integer filmeId, filmesEntity filmeRequest) {
        filmesEntity filme = getFilmeId(filmeId);
        filme.setStatus(filmeRequest.getStatus());
        filmesRepository.save(filme);
        return filme;
    }

    public filmesEntity getFilmeId(Integer filmeId) {
        return filmesRepository.findById(filmeId).orElse(null);
    }

    public List<filmesEntity> listarTodosFilmes() {
        return filmesRepository.findAll();
    }

    public void deletarFilme(Integer filmeId) {
        filmesEntity filme = getFilmeId(filmeId);
        filmesRepository.deleteById(filme.getId());
    }
}
