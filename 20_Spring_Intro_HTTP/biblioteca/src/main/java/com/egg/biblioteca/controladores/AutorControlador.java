package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/autor")
public class AutorControlador {
    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "autor_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam("nombre") String nombre, ModelMap modelo) {
        try {
            autorServicio.crearAutor(nombre);
            modelo.put("exito", "El autor fue cargado correctamente");
        } catch (MiException e) {
//            Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE, null, e);
            modelo.put("error", e.getMessage());
            return "autor_form.html";
        }

        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Autor> autores = autorServicio.listAutores();

        modelo.addAttribute("autores", autores);

        return "autor_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap modelo) {
        modelo.put("autor", autorServicio.findById(id));

        return "autor_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id,
                            @RequestParam String nombre,
                            RedirectAttributes redirectAttributes) {
        try {
            autorServicio.modificarAutor(nombre, id);
        } catch (MiException e) {
            // Add flash attribute so it persists after the redirect.
            // The attributes using 'modelo.put()' are not carried out over
            // redirection.
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            // It's recommended the use of absolute path over relative.
            return "redirect:/autor/modificar/" + id;
        }

        redirectAttributes.addFlashAttribute("exito", "El autor fue modificado correctamente");
        return "redirect:/autor/lista";
    }
}
