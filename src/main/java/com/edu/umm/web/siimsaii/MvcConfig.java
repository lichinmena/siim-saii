/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii;

import com.edu.umm.web.siimsaii.interceptors.TiempoTranscurridoInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author luis
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    @Autowired
    @Qualifier("tiempoTranscurridoInteceptor")
    private HandlerInterceptor tiempoTranscurridoInterceptor;
    
    @Autowired
    @Qualifier("horario")
    private HandlerInterceptor horario;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
       // registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**");
        registry.addInterceptor(tiempoTranscurridoInterceptor);
        registry.addInterceptor(horario).excludePathPatterns("/cerrado");
    }
    
}
