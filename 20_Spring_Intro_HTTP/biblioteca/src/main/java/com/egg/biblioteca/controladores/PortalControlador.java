package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class PortalControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    // The 'error' parameter comes from Spring Security's default behaviour ('SeguridadWeb.java).
    // It's automatically appended to '/login?error' when authentication fails.
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error,
                        ModelMap modelo) {
        if (error != null)
            modelo.put("error", "Usuario y/o Contraseña incorrectos!");
        return "login.html";
    }

//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(@AuthenticationPrincipal UserDetails userDetails, HttpSession session) {
        // Storing the authenticated user in the session
        if (session.getAttribute("usuariosession") == null) {
            Usuario usuario = usuarioServicio.findByEmail(userDetails.getUsername());
            session.setAttribute("usuariosession", usuario);
        }
//            session.setAttribute("usuariosession", userDetails);
        return "inicio.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String password2,
                           RedirectAttributes redirectAttributes) {
        try {
            usuarioServicio.registrar(nombre, email, password, password2);
        } catch (MiException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/registrar";
        }
        redirectAttributes.addFlashAttribute("exito", "El usuario fue creado exitosamente");
        return "redirect:/";
    }
}
