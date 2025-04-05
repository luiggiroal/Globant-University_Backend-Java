package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/dashboard")
    public String panelAdministrativo() {
        return "panel.html";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(ModelMap modelo) {
        modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());

        return "usuario_list.html";
    }

    @GetMapping("/modificarRol/{id}")
    public String modificarRol(@PathVariable UUID id, RedirectAttributes redirectAttributes) {
        Usuario usuario = new Usuario();
        try {
            usuarioServicio.cambiarRol(id);
            usuario = usuarioServicio.getById(id);
        } catch (MiException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/admin/usuarios";
        }
        redirectAttributes.addFlashAttribute("exito", "El rol del usuario %s fue modificado correctamente a %s".formatted(usuario.getNombre(), usuario.getRol().toString()));
        return "redirect:/admin/usuarios";
    }
}
