/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc.repositories;

import com.mycompany.practicajdbc.connection.ConexionBase;
import com.mycompany.practicajdbc.entities.Direccion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class AlumnoRepositorio {
    public AlumnoRepositorio() {}
    
    public void insertarAlumno(String nombre, int telefono, String direccion) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement insertar = conexion.createStatement();
        insertar.executeUpdate("INSERT INTO ALUMNOS VALUES('" + nombre + "', '" + telefono + "', '" + direccion + "')");
    }
}
