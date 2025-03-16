package com.egg.biblioteca.controladores;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import com.egg.biblioteca.servicios.EditorialServicio;
import com.egg.biblioteca.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/libro")
public class LibroControlador {
    @Autowired
    AutorServicio autorServicio;
    @Autowired
    EditorialServicio editorialServicio;
    @Autowired
    LibroServicio libroServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "libro_form.html";
    }

//  Names inside '@RequestParam' can be omitted as long as the method
//  parameter names match the request parameters.
    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn,
                           @RequestParam String titulo,
                           @RequestParam(required = false) Integer ejemplares,
                           @RequestParam String idAutor,
                           @RequestParam String idEditorial,
                           ModelMap modelo) {
        try {
//          Manual conversion from String to UUID. The conversion will take place only if
//          ID is not null, and it is not empty.
            UUID autorUUID = (idAutor != null && !idAutor.isEmpty()) ? UUID.fromString(idAutor) : null;
            UUID editorialUUID = (idEditorial != null && !idEditorial.isEmpty()) ? UUID.fromString(idEditorial) : null;

            libroServicio.crearLibro(isbn, titulo, ejemplares, autorUUID, editorialUUID);
            modelo.put("exito", "El libro fue cargado correctamente");
        } catch (MiException e) {
            modelo.put("error", e.getMessage());
            return "libro_form.html";
        }

        return "index.html";
    }
}
