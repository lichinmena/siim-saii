/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.controller;

import com.edu.umm.web.siimsaii.editors.PaisesEditor;
import com.edu.umm.web.siimsaii.editors.RolesEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.edu.umm.web.siimsaii.model.Role;
import com.edu.umm.web.siimsaii.model.Pais;
import com.edu.umm.web.siimsaii.model.Usuario;
import com.edu.umm.web.siimsaii.service.PaisService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.edu.umm.web.siimsaii.service.RoleService;
import java.util.Arrays;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author luis
 */
@Controller
@Slf4j
@RequestMapping("/usuarios")
@SessionAttributes("usuario")
public class UsuarioController 
{
    
    @Autowired private RoleService roleService;
    @Autowired private PaisService paisService;
    
    @Autowired private RolesEditor rolesEditor;
    @Autowired private PaisesEditor paisesEditor;
    
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Role.class,"roleList" , rolesEditor);
        binder.registerCustomEditor(Pais.class,"pais" , paisesEditor);
    }
    
    @ModelAttribute("roleList")
    public List<Role> roleList()
    {
        return this.roleService.findAll();
    }
    
    @ModelAttribute("paisList")
    public List<Pais> paisList()
    {
        return this.paisService.findAll();
    }
    
    @ModelAttribute("generoList")
    public List<String> generoList()
    {
        return Arrays.asList("Hombre","Mujer");
    }
    
    @GetMapping("/new")
    public String mostrarPaginaNew(Model model)
    {
        Usuario usuario = new Usuario();
        usuario.setNombre("Luis Fernando Mena Naal");
        usuario.setApellido("Mena Naal");
        usuario.setIdentificador("123.456.789-K");
        usuario.setUsername("luis_mena");
        usuario.setPassword("123456789");
        usuario.setEmail("luis_mena@outlook.com");
        usuario.setCuenta("112233445566778899");
        usuario.setHabilitar(true);
        usuario.setValorSecreto("Algun valor secreto ********");
        model.addAttribute("usuario", usuario);
        model.addAttribute("path" ,"/usuarios/new");
        model.addAttribute("title","Nuevo usuario");
        return "usuarios/new_usuario";
    }
    
    @PostMapping("/save")
    public  String guardarUsuario(@Valid Usuario usuario, BindingResult result, Model model)
    {
        model.addAttribute("path", "/usuarios/show");
        if(result.hasErrors())
        {
            return "usuarios/new_usuario"; 
        }
      
        return "redirect:/usuarios/show_usuario";
    }
    
    
    @GetMapping("/show_usuario")
    public String showUsuario(@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status)
    {
        if(usuario == null)
        {
            log.info("usuario ==> is null");
            return "redirect:/usuarios/new";
        }
        
        model.addAttribute("titulo", "Información de usuario");
        status.setComplete();
        return "usuarios/show_usuario";
    }
    
}
