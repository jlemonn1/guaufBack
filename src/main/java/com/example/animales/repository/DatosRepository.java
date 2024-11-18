package com.example.animales.repository;

import com.example.animales.entity.Datos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DatosRepository extends JpaRepository<Datos, Long> {


}

