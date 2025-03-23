package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MiException {
        validar(nombre);
        Autor autor = new Autor();

        autor.setNombre(nombre);

        autorRepositorio.save(autor);
    }

    @Transactional(readOnly = true)
    public List<Autor> listAutores() {
        List<Autor> autores = new ArrayList<>();

        autores = autorRepositorio.findAll();

        return autores;
    }

    @Transactional
    public void modificarAutor(String nombre, UUID id) throws MiException {
        validar(nombre);
        Autor autor = autorRepositorio.findById(id).orElseThrow(() -> new MiException("Autor con id %s no encontrado.".formatted(id)));

        autor.setNombre(nombre);

        autorRepositorio.save(autor);
    }

    @Transactional(readOnly = true)
    public Autor findById(UUID id) {
        return autorRepositorio.findById(id).orElse(null);
    }

    public void validar(String nombre) throws MiException{
        if (nombre == null || nombre.isEmpty())
            throw new MiException("El nombre no puede ser nulo o estar vacío");
    }

}
