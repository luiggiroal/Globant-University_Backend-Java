package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EditorialServicio {
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws MiException {
        validar(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = new ArrayList<>();

        editoriales = editorialRepositorio.findAll();

        return editoriales;
    }

    @Transactional
    public void modficarEditorial(String nombre, UUID id) throws MiException {
        validar(nombre);
        Editorial editorial = editorialRepositorio.findById(id).orElseThrow(() -> new MiException("Editorial con id %s no encontrado".formatted(id)));

        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    public void validar(String nombre) throws MiException {
        if (nombre == null || nombre.isEmpty())
            throw new MiException("El nombre no puede ser nulo o estar vacío");
    }
}
