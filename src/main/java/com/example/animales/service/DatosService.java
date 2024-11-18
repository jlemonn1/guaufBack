package com.example.animales.service;

import com.example.animales.entity.Datos;
import java.util.List;
import java.util.Optional;

public interface DatosService {

    Datos saveDatos(Datos datos);                // Crear o actualizar
    List<Datos> getAllDatos();                   // Leer todos
    Optional<Datos> getDatosById(Long id);       // Leer por ID
    Datos updateDatos(Datos datos);              // Actualizar
    void deleteDatos(Long id);                   // Eliminar por ID
}
