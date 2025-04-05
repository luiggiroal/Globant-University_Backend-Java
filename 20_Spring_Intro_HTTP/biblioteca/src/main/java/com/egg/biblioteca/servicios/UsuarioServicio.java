package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServicio implements UserDetailsService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws MiException {
        validar(nombre, email, password, password2);
        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);

        usuarioRepositorio.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario findByEmail(String email) {
        return usuarioRepositorio.buscarPorEmail(email);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        usuarios = usuarioRepositorio.findAll();

        return usuarios;
    }

    @Transactional
    public void cambiarRol(UUID id) throws MiException {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new MiException("Usuario con id %s no encontrado".formatted(id)));

        if (usuario.getRol().equals(Rol.ADMIN))
            usuario.setRol(Rol.USER);
        else if (usuario.getRol().equals(Rol.USER))
            usuario.setRol(Rol.ADMIN);
    }

    @Transactional(readOnly = true)
    public Usuario getById(UUID id) throws MiException {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new MiException("Usuario con id %s no encontrado".formatted(id)));

        return usuario;
    }

    // Since 'UserNameNotFoundException' is an unchecked exception it doesn't require
    // explicit declaration ('throws UserNameNotFoundException'), however it's recommended
    // to include it because of readability purposes.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);

        if (usuario == null)
            throw new UsernameNotFoundException("Usuario no encontrado con email %s.".formatted(email));

        List<GrantedAuthority> permisos = new ArrayList<>();
        permisos.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString()));

        // Getting the current request attributes
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        // Getting the request session
        HttpSession session = attr.getRequest().getSession(true);
        // Setting session attribute with 'usuario'
        session.setAttribute("usuariosession", usuario);

        return new User(usuario.getEmail(), usuario.getPassword(), permisos);
    }

    public void validar(String nombre, String email, String password, String password2) throws MiException {
        if (nombre == null || nombre.isEmpty())
            throw new MiException("El nombre no puede ser nulo o estar vacío");
        if (email == null || email.isEmpty())
            throw new MiException("El email no puede ser nulo o estar vacío");
        if (password == null || password.length() <= 5) // 'password.isEmpty()' is covered by 'password.length()'
            throw new MiException("La constraseña no puede ser nula o estar vacía, y debe tener más de 5 carácteres.");
        if (password2 == null || password2.length() <= 5)
            throw new MiException("La confirmación de constraseña no puede ser nula o estar vacía, y debe tener más de 5 carácteres.");
        if (!password.equals(password2))
            throw new MiException("La confirmación de contraseña debe ser igual a la original");
    }
}
