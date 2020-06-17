package com.example.proyectosemestral;

import android.widget.CheckBox;

import java.io.Serializable;

public class Productos implements Serializable {
    private String titulo;
    private String descripcion;
    private String descripciondetalle;
    private int foto;
    private int fotodetalle;


    public Productos(){

    }

    public Productos(String titulo, String descripcion, String descripciondetalle, int foto, int fotodetalle) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.descripciondetalle = descripciondetalle;
        this.foto = foto;
        this.fotodetalle = fotodetalle;
    }

    public String getDescripciondetalle() {
        return descripciondetalle;
    }

    public void setDescripciondetalle(String descripciondetalle) {
        this.descripciondetalle = descripciondetalle;
    }

    public int getFotodetalle() {
        return fotodetalle;
    }

    public void setFotodetalle(int fotodetalle) {
        this.fotodetalle = fotodetalle;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


}
