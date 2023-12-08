
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
    ArrayList<String> direccion;
    
    public Alumno(int id, String nombre, int telefono, ArrayList<String> direccion) {
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

    public ArrayList<String> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<String> direccion) {
        this.direccion = direccion;
    }   
    
    @Override
    public String toString() {
        StringBuilder direccionString = new StringBuilder();
        int indice = 0;
        for (String direcciones : direccion) {
            direccionString.append(direcciones);
            if (indice < direccion.size() - 1) {
                direccionString.append(", ");
            }
            indice++;
        }
        return "ID: " + id + "\nNombre: " + nombre + "\nTelefono: " + telefono 
                + "\nDireccion: " + direccionString;
    }
}
