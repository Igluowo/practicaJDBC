/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc.repositories;

import com.mycompany.practicajdbc.connection.ConexionBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erick
 */
public class DireccionRepositorio {
    public DireccionRepositorio() {}
    
    /* EjercicioD (ii): Insertar */
    public void insertarDireccion(String direccion, int idAlumno) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement insertar = conexion.createStatement();
        insertar.executeUpdate("INSERT INTO Direccion VALUES(" + idAlumno + ", '" + direccion + "')");
    }
    
    /* EjercicioF (i): Eliminar */
    public void eliminarDireccion(int idAlumno) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement eliminar = conexion.createStatement();
        eliminar.executeUpdate("DELETE FROM Direccion where idAlumno = " + idAlumno);
    }
    
    /* EjercicioG: Consultar */
    public ResultSet consultar() throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement consultar = conexion.createStatement();
        return consultar.executeQuery("SELECT * FROM Direccion");
    }
}
