/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.atividade3PI.service;

import com.trabalho.atividade3PI.data.jogosEntity;
import com.trabalho.atividade3PI.data.jogosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilh
 */
@Service
public class jogosService {

    @Autowired
    jogosRepository jogosRepository;

    public jogosEntity adicionarJogo(jogosEntity jogo) {
        jogo.setId(null);
        jogosRepository.save(jogo);
        return jogo;
    }

    public jogosEntity atualizarStatusJogo(Integer jogoId, jogosEntity jogoRequest) {
        jogosEntity jogo = getJogoId(jogoId);
        jogo.setStatus(jogoRequest.getStatus());
        jogosRepository.save(jogo);
        return jogo;
    }

    public jogosEntity getJogoId(Integer jogoId) {
        return jogosRepository.findById(jogoId).orElse(null);
    }

    public List<jogosEntity> listarTodosJogos() {
        return jogosRepository.findAll();
    }

    public void deletarJogo(Integer jogoId) {
        jogosEntity jogo = getJogoId(jogoId);
        jogosRepository.deleteById(jogo.getId());
    }
}
