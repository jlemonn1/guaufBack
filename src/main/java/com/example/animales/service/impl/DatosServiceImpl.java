package com.example.animales.service.impl;

import com.example.animales.entity.Datos;
import com.example.animales.repository.DatosRepository;
import com.example.animales.service.DatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatosServiceImpl implements DatosService {

    @Autowired
    private DatosRepository datosRepository;

    // Guardar o actualizar datos
    @Override
    public Datos saveDatos(Datos datos) {
        return datosRepository.save(datos);
    }

    // Obtener todos los registros
    @Override
    public List<Datos> getAllDatos() {
        return datosRepository.findAll();
    }

    // Obtener registro por ID
    @Override
    public Optional<Datos> getDatosById(Long id) {
        return datosRepository.findById(id);
    }

    // Actualizar datos
    @Override
    public Datos updateDatos(Datos datos) {
        return datosRepository.save(datos);  // save() también maneja la actualización si el ID ya existe
    }

    // Eliminar por ID
    @Override
    public void deleteDatos(Long id) {
        datosRepository.deleteById(id);
    }
}
