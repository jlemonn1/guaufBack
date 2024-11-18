package com.example.animales.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Datos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean registrado;
    //Animal
    private String nombreMascota;
    private String raza;
    @Lob // Anotación para hacer 'description' un long text
    @Column(columnDefinition = "TEXT") // Opcional: define explícitamente el tipo SQL
    private String infoMascota;

    //Personal
    private String nombre;
    private String numero;
    private String direccion;
    @Lob // Anotación para hacer 'description' un long text
    @Column(columnDefinition = "TEXT") // Opcional: define explícitamente el tipo SQL
    private String infoDueno;

    @Lob // Para almacenar la imagen como un arreglo de bytes
    @Column(columnDefinition = "LONGBLOB") // Define explícitamente como MEDIUMBLOB
    private byte[] foto; // Este es el nuevo campo para la imagen

    private boolean whatsapp;


    // Constructor, getters, setters, and other methods
    public Datos(){

    }

    public Datos(boolean registrado, String nombreMascota, String raza, String infoMascota, String nombre, String numero, String direccion, String infoDueno, byte[] foto, boolean whatsapp){
        this.registrado = registrado;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.infoMascota = infoMascota;
        this.nombre = nombre;
        this.numero = numero;
        this.direccion = direccion;
        this.infoDueno = infoDueno;
        this.foto = foto;
        this.whatsapp = whatsapp;
    }


    public Long getId() {
        return id;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getInfoMascota() {
        return infoMascota;
    }

    public void setInfoMascota(String infoMascota) {
        this.infoMascota = infoMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getInfoDueno() {
        return infoDueno;
    }

    public void setInfoDueno(String infoDueno) {
        this.infoDueno = infoDueno;
    }

    public byte[] getFoto(){
        return this.foto;
    }

    public void setFoto(byte[] foto){
        this.foto = foto;
    }

    public boolean isWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

}
    