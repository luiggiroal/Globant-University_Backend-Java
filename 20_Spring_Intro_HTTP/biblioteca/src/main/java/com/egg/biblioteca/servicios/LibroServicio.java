package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        Libro libro = new Libro();

        Autor autor = autorRepositorio.findById(idAutor).orElseThrow(() -> new MiException("Autor con id %s no encontrado.".formatted(idAutor)));
        Editorial editorial = editorialRepositorio.findById(idEditorial).orElseThrow(() -> new MiException("Editorial con id %s no encontrada.".formatted(idEditorial)));

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();

        libros = libroRepositorio.findAll();

        return libros;
    }

    @Transactional
    public void modificarLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        Libro libro = libroRepositorio.findById(isbn).orElseThrow(() -> new MiException("Libro con isbn %d no encontrado".formatted(isbn)));
        Autor autor = autorRepositorio.findById(idAutor).orElseThrow(() -> new MiException("Autor con id %s no encontrado".formatted(idAutor)));
        Editorial editorial = editorialRepositorio.findById(idEditorial).orElseThrow(() -> new MiException("Editorial con id %s no encontrado".formatted(idEditorial)));

        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }

    @Transactional(readOnly = true)
    public Libro findByIsbn(Long isbn) {
        return libroRepositorio.findById(isbn).orElse(null);
    }

    public void validar(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
        if (isbn == null)
            throw new MiException("El ISBN no puede ser nulo.");

        if (titulo == null || titulo.trim().isEmpty())
            throw new MiException("El título no puede ser nulo ni estar vacío");

        if (ejemplares == null)
            throw new MiException("La cantidad de ejemplares no puede ser nula");

        if (idAutor == null)
            throw new MiException("Debe seleccionar un Autor");

        if (idEditorial == null)
            throw new MiException("Debe seleccionar una Editorial");
    }
}
