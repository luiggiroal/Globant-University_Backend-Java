package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import com.egg.biblioteca.servicios.EditorialServicio;
import com.egg.biblioteca.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/libro")
public class LibroControlador {
    @Autowired
    private AutorServicio autorServicio;
    @Autowired
    private EditorialServicio editorialServicio;
    @Autowired
    private LibroServicio libroServicio;

    @GetMapping("/registrar")
    public String registrar(ModelMap modelo) {
        List<Autor> autores = autorServicio.listAutores();
        List<Editorial> editoriales = editorialServicio.listarEditoriales();

        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);

        return "libro_form.html";
    }

    //  Names inside '@RequestParam' can be omitted as long as the method
    //  parameter names match the request parameters.
    //
    //  If the form doesn't provide a value for the parameters marked with 'required=false',
    //  Spring will bind them as null instead of raising an exception.
    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn,
                           @RequestParam String titulo,
                           @RequestParam(required = false) Integer ejemplares,
                           @RequestParam(required = false) UUID idAutor,
                           @RequestParam(required = false) UUID idEditorial,
                           RedirectAttributes redirectAttributes) {
        try {
            libroServicio.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
        } catch (MiException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/libro/registrar";
        }
        redirectAttributes.addFlashAttribute("exito", "El libro fue cargado correctamente");
        return "redirect:/inicio";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Libro> libros = libroServicio.listarLibros();

        modelo.addAttribute("libros", libros);

        return "libro_list.html";
    }

    @GetMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn, ModelMap modelo) {
        Libro libro = libroServicio.findByIsbn(isbn);
        List<Autor> autores = autorServicio.listAutores();
        List<Editorial> editoriales = editorialServicio.listarEditoriales();

        modelo.put("libro", libro);
        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);

        return "libro_modificar.html";
    }

    @PostMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn,
                            @RequestParam String titulo,
                            @RequestParam(required = false) Integer ejemplares,
                            @RequestParam(required = false) UUID idAutor,
                            @RequestParam(required = false) UUID idEditorial,
                            RedirectAttributes redirectAttributes) {
        try {
            libroServicio.modificarLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
        } catch (MiException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/libro/modificar/" + isbn;
        }
        redirectAttributes.addFlashAttribute("exito", "El libro fue modificado correctamente");
        return "redirect:/libro/lista";
    }
}
