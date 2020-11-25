/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.model;

import lombok.Data;

/**
 *
 * @author luis
 */
@Data
public class Pais 
{
    private Integer id;
    private String codigo;
    private String nombre;

    public Pais() {
    }

    public Pais(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    
    
}
