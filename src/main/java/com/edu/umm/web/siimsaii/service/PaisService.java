/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.service;

import com.edu.umm.web.siimsaii.impl.PaisImpl;
import com.edu.umm.web.siimsaii.model.Pais;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis
 */
@Service
public class PaisService implements PaisImpl
{
    private List<Pais> lista;
    
    public PaisService()
    {
        this.lista = Arrays.asList(
                new Pais(1, "ES","España"),
                 new Pais(2, "MX","México"),
                  new Pais(3, "CL","Chile"),
                   new Pais(4, "AR","Argentina"),
                    new Pais(5, "PE","Perú"),
                     new Pais(6, "CO","Colombia"),
                      new Pais(7, "ES","Venenzuela")
                );
    }

    @Override
    public List<Pais> findAll()
    {
        return lista;
    }

    @Override
    public Pais findById(Integer id) 
    {
        Pais resultado = null;
        for(Pais pais : lista)
        {
            if(Objects.equals(id, pais.getId()))
            {
                resultado = pais;
                break;
            }
            
        }
        return  resultado;
    }
    
    
}
