/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.service;

import com.edu.umm.web.siimsaii.impl.RoleImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.edu.umm.web.siimsaii.model.Role;
import java.util.Objects;

/**
 *
 * @author luis
 */
@Service
public class RoleService implements RoleImpl
{
    private List<Role> roleList;
    
    public RoleService()
    {
        this.roleList = new ArrayList<>();
        this.roleList.add(new Role(1, "Administrador", "ROLE_ADMIN"));
        this.roleList.add(new Role(2, "Usuario"      , "ROLE_USER"));
        this.roleList.add(new Role(3, "Moderador"    , "ROLE_MODERATOR"));
    }
    
    @Override
    public List<Role> findAll()
    {
        return roleList;
    }

    @Override
    public Role findById(Integer id) 
    {
        Role resultado = null;
        for(Role role : roleList)
        {
            if(Objects.equals(id, role.getId()))
            {
                resultado = role;
                break;
            }
            
        }
        return  resultado;
    }
    
}
