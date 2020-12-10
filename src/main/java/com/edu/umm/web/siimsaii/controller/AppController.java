/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author luis
 */
@Controller
public class AppController
{
    
    @GetMapping({"/","index"})
    public String index(Model model)
    {
        model.addAttribute("titulo", "Bienvenido al horario de atencion a clientes");
        return "index";
    }
}
