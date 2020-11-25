/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.impl;

import java.util.List;
import com.edu.umm.web.siimsaii.model.Pais;
/**
 *
 * @author luis
 */
public interface PaisImpl
{
    public List<Pais> findAll();
    public Pais findById(Integer id);
}
