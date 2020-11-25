/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.model;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author luis
 */
@Data
public class Usuario
{
    private String identificador;
    
    private String nombre;
    
    private String apellido;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private String cuenta;
    
    private Date fechaNacimiento;
    
    @NotEmpty
    private List<Role> roleList;
    
    @NotNull
    private Pais pais;
    
    private Boolean habilitar;
    
    @NotEmpty
    private String genero;
    
    private String valorSecreto;
   
    
}
