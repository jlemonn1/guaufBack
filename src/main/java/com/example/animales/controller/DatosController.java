package com.example.animales.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.animales.entity.Datos;
import com.example.animales.service.DatosService;

@RestController
@RequestMapping("/api/datos")
@CrossOrigin(origins = "*")
public class DatosController {

    private DatosService datosService;

    @Autowired
    public DatosController(DatosService datosService) {
        this.datosService = datosService;
    }

    // Método para obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Datos> getDatosById(@PathVariable Long id) {
        Optional<Datos> datos = datosService.getDatosById(id);
        if (datos.isPresent()) {
            return ResponseEntity.ok(datos.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo registro (Solo ID y registrado en false, resto vacío)
    @PostMapping("/nuevo")
    public ResponseEntity<Datos> crearNuevoRegistro() {
        Datos nuevoDatos = new Datos();
        nuevoDatos.setRegistrado(false);

        Datos datosGuardados = datosService.saveDatos(nuevoDatos);
        return ResponseEntity.ok(datosGuardados);
    }

    // Actualizar un registro existente por ID (si no está registrado)

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarDatos(@PathVariable Long id,
            @RequestParam(required = false) MultipartFile foto,
            @RequestParam(required = false) String nombreMascota,
            @RequestParam(required = false) String raza,
            @RequestParam(required = false) String infoMascota,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String numero,
            @RequestParam(required = false) String direccion,
            @RequestParam(required = false) String infoDueno,
            @RequestParam(required = false) boolean whatsapp) {
        Optional<Datos> datosExistentesOpt = datosService.getDatosById(id);

        if (datosExistentesOpt.isEmpty()) {
            return ResponseEntity.notFound().build(); // Registro no encontrado
        }

        Datos datosExistentes = datosExistentesOpt.get();

        // Verificar si ya está registrado
        if (datosExistentes.isRegistrado()) {
            return ResponseEntity.status(403).body("Este registro ya está registrado y no se puede actualizar.");
        }

        // Actualizar campos
        if (nombreMascota != null) {
            datosExistentes.setNombreMascota(nombreMascota);
        }
        if (raza != null) {
            datosExistentes.setRaza(raza);
        }
        if (infoMascota != null) {
            datosExistentes.setInfoMascota(infoMascota);
        }
        if (nombre != null) {
            datosExistentes.setNombre(nombre);
        }
        if (numero != null) {
            datosExistentes.setNumero(numero);
        }
        if (direccion != null) {
            datosExistentes.setDireccion(direccion);
        }
        if (infoDueno != null) {
            datosExistentes.setInfoDueno(infoDueno);
        }

        datosExistentes.setWhatsapp(whatsapp);
        ;

        // Manejo de la imagen
        if (foto != null && !foto.isEmpty()) {
            try {
                datosExistentes.setFoto(foto.getBytes());
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Error al procesar la imagen.");
            }
        }

        // Cambiar el estado de registrado a true
        datosExistentes.setRegistrado(true);

        Datos datosActualizadosGuardados = datosService.updateDatos(datosExistentes);

        return ResponseEntity.ok(datosActualizadosGuardados);
    }

    @DeleteMapping("/remove/{id}")
    public void eliminar(@PathVariable Long id) {
        datosService.deleteDatos(id);
    }

    @PutMapping("/flush/{id}")
    public ResponseEntity<?> actualizarDatos(@PathVariable Long id) {
        Optional<Datos> datosExistentesOpt = datosService.getDatosById(id);

        if (datosExistentesOpt.isEmpty()) {
            return ResponseEntity.notFound().build(); // Registro no encontrado
        }

        Datos datosExistentes = datosExistentesOpt.get();

        // Actualizar campos
        datosExistentes.setNombreMascota(null);

        datosExistentes.setRaza(null);

        datosExistentes.setInfoMascota(null);

        datosExistentes.setNombre(null);

        datosExistentes.setNumero(null);

        datosExistentes.setDireccion(null);

        datosExistentes.setInfoDueno(null);

        datosExistentes.setWhatsapp(false);
    
        datosExistentes.setFoto(null);

        // Cambiar el estado de registrado a true
        datosExistentes.setRegistrado(false);

        Datos datosActualizadosGuardados = datosService.updateDatos(datosExistentes);

        return ResponseEntity.ok(datosActualizadosGuardados);
    }

}
