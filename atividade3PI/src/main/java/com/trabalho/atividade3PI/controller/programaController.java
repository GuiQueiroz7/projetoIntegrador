/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho.atividade3PI.controller;

import com.trabalho.atividade3PI.data.filmesEntity;
import com.trabalho.atividade3PI.data.jogosEntity;
import com.trabalho.atividade3PI.data.livrosEntity;
import com.trabalho.atividade3PI.data.seriesEntity;
import com.trabalho.atividade3PI.data.usuarioEntity;
import com.trabalho.atividade3PI.service.filmesService;
import com.trabalho.atividade3PI.service.jogosService;
import com.trabalho.atividade3PI.service.livrosService;
import com.trabalho.atividade3PI.service.seriesService;
import com.trabalho.atividade3PI.service.usuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author guilh
 */
@Controller
public class programaController {

    @Autowired
    usuariosService userService;
    @Autowired
    filmesService filmesService;
    @Autowired
    seriesService seriesService;
    @Autowired
    livrosService livrosService;
    @Autowired
    jogosService jogosService;

    @RequestMapping("/")
    public String telaLogin(Model model) {
        model.addAttribute("user", new usuarioEntity());
        return "telaLogin";
    }

    @PostMapping("/")
    public ModelAndView login(@ModelAttribute usuarioEntity user) {
        String tela = "";
        List<usuarioEntity> listaAnalises = userService.listarTodosUsuarios();
        for (int i = 0; i < listaAnalises.size(); i++) {
            usuarioEntity userAtual = listaAnalises.get(i);
            if (userAtual.getLogin().equals(user.getLogin()) && userAtual.getSenha().equals(user.getSenha())) {
                tela = "telaPrincipal";
            }
        }
        return new ModelAndView("redirect:/" + tela);
    }

    @GetMapping("/telaPrincipal")
    public String telaPrincipal(Model model) {
        model.addAttribute("filme", new filmesEntity());
        model.addAttribute("serie", new seriesEntity());
        model.addAttribute("livro", new livrosEntity());
        model.addAttribute("jogo", new jogosEntity());
        return "telaPrincipal";
    }

    @PostMapping("/attFilme")
    public ModelAndView attFilme(@ModelAttribute filmesEntity filme) {
        List<filmesEntity> listaFilmes = filmesService.listarTodosFilmes();
        for (int i = 0; i < listaFilmes.size(); i++) {
            filmesEntity filmeAtual = listaFilmes.get(i);
            if(filmeAtual.getNome().equals(filme.getNome())){
                filmesService.atualizarStatusFilme(filmeAtual.getId(), filme);
            }
        }
        return new ModelAndView("redirect:/telaPrincipal");
    }
    
    @PostMapping("/attSerie")
    public ModelAndView attSerie(@ModelAttribute seriesEntity serie) {
        List<seriesEntity> listaSeries = seriesService.listarTodasSeries();
        for (int i = 0; i < listaSeries.size(); i++) {
            seriesEntity serieAtual = listaSeries.get(i);
            if(serieAtual.getNome().equals(serie.getNome())){
                seriesService.atualizarStatusSerie(serieAtual.getId(), serie);
            }
        }
        return new ModelAndView("redirect:/telaPrincipal");
    }
    
    @PostMapping("/attLivro")
    public ModelAndView attLivro(@ModelAttribute livrosEntity livro) {
        List<livrosEntity> listaLivros = livrosService.listarTodosLivros();
        for (int i = 0; i < listaLivros.size(); i++) {
            livrosEntity livroAtual = listaLivros.get(i);
            if(livroAtual.getNome().equals(livro.getNome())){
                livrosService.atualizarStatusLivro(livroAtual.getId(), livro);
            }
        }
        return new ModelAndView("redirect:/telaPrincipal");
    }
    
    @PostMapping("/attJogo")
    public ModelAndView attjogo(@ModelAttribute jogosEntity filme) {
        List<jogosEntity> listaJogos = jogosService.listarTodosJogos();
        for (int i = 0; i < listaJogos.size(); i++) {
            jogosEntity jogoAtual = listaJogos.get(i);
            if(jogoAtual.getNome().equals(filme.getNome())){
                jogosService.atualizarStatusJogo(jogoAtual.getId(), filme);
            }
        }
        return new ModelAndView("redirect:/telaPrincipal");
    }

    @GetMapping("/telaCadastro")
    public String telaCad() {
        return "telaCadastro";
    }
}
