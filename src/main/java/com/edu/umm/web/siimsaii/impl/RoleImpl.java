/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.impl;

import java.util.List;
import com.edu.umm.web.siimsaii.model.Role;
/**
 *
 * @author luis
 */
public interface RoleImpl
{
    public List<Role> findAll();
    public Role findById(Integer id);
}
