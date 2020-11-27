/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umm.web.siimsaii.interceptors;

import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author luis
 */
@Component("tiempoTranscurridoInteceptor")
@Slf4j
public class TiempoTranscurridoInteceptor  implements HandlerInterceptor
{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        if(request.getMethod().equalsIgnoreCase("post"))
        {
            return true;
        }
        
        if(handler instanceof HandlerMethod)
        {
            HandlerMethod metodo = (HandlerMethod) handler;
            log.info("es un metodo del controlador: " + metodo.getMethod().getName());
        }
        
        log.info("TiempoTranscurridoInteceptor: preHandle() entrando...");
        log.info("Interceptando handler :: " + handler);
        long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);
        
        Random random = new Random();
        Integer demora = random.nextInt(500);
        Thread.sleep(demora);
        
        
        //response.sendRedirect(request.getContextPath().concat("/login"));
        //return false;
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        if(request.getMethod().equalsIgnoreCase("post"))
        {
            return ;
        }
        
        long tiempoFin    = System.currentTimeMillis();
        long tiempoInicio = (Long)request.getAttribute("tiempoInicio");
        long tiempoTranscurrido = tiempoFin - tiempoInicio;
        if(handler instanceof HandlerMethod && modelAndView != null)
        {
            modelAndView.addObject("tiempoTranscurrido" , tiempoTranscurrido);
        }
        log.info("Tiempo Transcurrido :: " + tiempoTranscurrido + " milisegundos");
        log.info("TiempoTranscurridoInteceptor: postHandle() saliendo...");
    }


    
}
