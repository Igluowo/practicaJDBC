/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc.repositories;

import com.mycompany.practicajdbc.connection.ConexionBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erick
 */
public class DireccionRepositorio {
    public DireccionRepositorio() {}
    
    public void insertarDireccion(String direccion, int idAlumno) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement insertar = conexion.createStatement();
        insertar.executeUpdate("INSERT INTO Direccion VALUES(" + idAlumno + ", '" + direccion + "')");
    }
}
