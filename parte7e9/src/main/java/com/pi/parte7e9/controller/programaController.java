/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.parte7e9.controller;

import com.pi.parte7e9.data.usuarioEntity;
import com.pi.parte7e9.service.usuariosService;
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
    
    usuarioEntity userEscolhido = new usuarioEntity();

    @RequestMapping("/")
    public String telaLogin(Model model) {
        model.addAttribute("user", new usuarioEntity());
        return "telaLogin";
    }

    @PostMapping("/")
    public ModelAndView login(@ModelAttribute usuarioEntity user) {
        String tela = "";
        List<usuarioEntity> listaAnalises = userService.listarTodosUsuarios();
        for(int i=0; i<listaAnalises.size(); i++){
            usuarioEntity userAtual = listaAnalises.get(i);
            if(userAtual.getLogin().equals(user.getLogin()) && userAtual.getSenha().equals(user.getSenha())){
                tela = "telaPrincipal";
                userEscolhido = userAtual;
            }
        }
        return new ModelAndView("redirect:/"+tela); 
    }
    
    @GetMapping("/telaPrincipal")
    public String telaPrincipal(Model model) {
        model.addAttribute(userEscolhido);
        return "telaPrincipal";
    }
    
    @GetMapping("/telaCadastro")
    public String telaCad() {
        return "telaCadastro";
    }
}
