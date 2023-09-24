/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.parte7e9.service;

import com.pi.parte7e9.data.seriesEntity;
import com.pi.parte7e9.data.seriesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilh
 */
@Service
public class seriesService {

    @Autowired
    seriesRepository seriesRepository;

    public seriesEntity adicionarSerie(seriesEntity serie) {
        serie.setId(null);
        seriesRepository.save(serie);
        return serie;
    }

    public seriesEntity atualizarStatusSerie(Integer serieId, seriesEntity serieRequest) {
        seriesEntity serie = getSerieId(serieId);
        serie.setStatus(serieRequest.getStatus());
        seriesRepository.save(serie);
        return serie;
    }

    public seriesEntity getSerieId(Integer serieId) {
        return seriesRepository.findById(serieId).orElse(null);
    }

    public List<seriesEntity> listarTodasSeries() {
        return seriesRepository.findAll();
    }

    public void deletarSerie(Integer serieId) {
        seriesEntity serie = getSerieId(serieId);
        seriesRepository.deleteById(serie.getId());
    }
}
