package com.egg.biblioteca.controladores;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErroresControlador implements ErrorController {
    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        // ModelAndView -> Unlike 'ModelMap' encapsulates both the model and the view in one object.
        ModelAndView errorPage = new ModelAndView("error");
        String erroMsg = "";
        Integer errorCode = getErrorCode(httpRequest);

        switch (errorCode) {
            case 400 -> erroMsg = "El recurso solicitado no existe";
            case 401 -> erroMsg = "No se encuentra autorizado";
            case 403 -> erroMsg = "No tiene permisos para acceder a este recurso";
            case 404 -> erroMsg = "El recurso solicitado no fue encontrado";
            case 500 -> erroMsg = "Ocurrió un error interno";
            default -> erroMsg = "Se produjo un error inesperado";
        }

        errorPage.addObject("codigo", errorCode);
        errorPage.addObject("mensaje", erroMsg);

        return errorPage;
    }

    private Integer getErrorCode(HttpServletRequest httpRequest) {
        Object statusCode = httpRequest.getAttribute("jakarta.servlet.error.status_code");

        if (statusCode instanceof Integer)
            return (Integer) statusCode;

        return -1;
    }

    public String getErrorPath() {
        return "/error.html";
    }
}
