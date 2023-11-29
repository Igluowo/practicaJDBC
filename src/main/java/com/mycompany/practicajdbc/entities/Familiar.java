/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc.entities;

/**
 *
 * @author 2damb
 */
public class Familiar {
    int id;
    int idAlumno;
    String nombre;
    String sexo;
    int telefono;
    boolean custodia;

    public Familiar(int id, int idAlumno, String nombre, String sexo, int telefono, boolean custodia) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        this.custodia = custodia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isCustodia() {
        return custodia;
    }

    public void setCustodia(boolean custodia) {
        this.custodia = custodia;
    }        
}
