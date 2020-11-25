/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.editors;

import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.edu.umm.web.siimsaii.impl.RoleImpl;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author luis
 */
@Component
@Slf4j
public class RolesEditor extends PropertyEditorSupport
{
    @Autowired
    private RoleImpl roleService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException 
    {
        try 
        {
            log.info("Error -> RolesEditor :: " + text);
            Integer id = Integer.parseInt(text);
            setValue(roleService.findById(id));
        } 
        catch (NumberFormatException e) 
        {
            setValue(null);
        }
    }
    
    
}
