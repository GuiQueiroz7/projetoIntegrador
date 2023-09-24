/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.atividade3PI.controller;

import com.trabalho.atividade3PI.data.seriesEntity;
import com.trabalho.atividade3PI.service.seriesService;
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
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    seriesService seriesService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllSeries() {
        List<seriesEntity> series = seriesService.listarTodasSeries();
        return new ResponseEntity<>(series, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<seriesEntity> getSeriesById(@PathVariable Integer id) {
        seriesEntity serie = seriesService.getSerieId(id);
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<seriesEntity> addSerie(@RequestBody seriesEntity serie) {
        var novaSerie = seriesService.adicionarSerie(serie);
        return new ResponseEntity<>(novaSerie, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<seriesEntity> atualizarSerie(@PathVariable Integer id, @RequestBody seriesEntity serie) {
        var serieAtualizada = seriesService.atualizarStatusSerie(id, serie);
        return new ResponseEntity<>(serieAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarSerie(@PathVariable Integer id) {
        seriesService.deletarSerie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
