/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.editors;

import com.edu.umm.web.siimsaii.service.PaisService;
import java.beans.PropertyEditorSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis
 */

@Component
@Slf4j
public class PaisesEditor extends PropertyEditorSupport
{
    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException
    {
        if (idString != null && idString.length() > 0)
        {
            try
            {
                log.info("Error -> PaisesEditor :: " + idString);
                Integer id = Integer.parseInt(idString);
                this.setValue(paisService.findById(id));
            }
            catch (NumberFormatException e)
            {
                setValue(null);
            }
        } 
        else 
        {
             setValue(null);
        }
        

    }
    
    
    
    
}
