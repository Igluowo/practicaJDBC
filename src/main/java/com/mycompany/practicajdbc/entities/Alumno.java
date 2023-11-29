
package com.mycompany.practicajdbc.entities;

import java.util.ArrayList;

/**
 *
 * @author 2damb
 */
public class Alumno {
    int id;
    String nombre;
    int telefono;
    ArrayList<Direccion> direccion;
    
    public Alumno(int id, String nombre, int telefono, ArrayList<Direccion> direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<Direccion> direccion) {
        this.direccion = direccion;
    }   
}
