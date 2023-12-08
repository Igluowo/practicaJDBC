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
public class AsignaturaRepositorio {
    
    /* EjercicioE (i): Actualizar */
    public void actualizarAsignatura(int idAlumno, int id, String asignatura) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement actualizar = conexion.createStatement();
        actualizar.executeUpdate("update Asignaturas\n"
                + "set nombre = '" + asignatura + "'\n" 
                + "where idAlumno = " + idAlumno + " and id = " + id);
    }
    
    /* EjercicioF (ii): Eliminar */
    public void eliminarAsignatura(int idAlumno, int idAsignatura) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement eliminar = conexion.createStatement();
        eliminar.executeUpdate("DELETE FROM Asignaturas where id = " + idAsignatura + "and idAlumno = " + idAlumno);
    }
    
    /* EjercicioG: Consultar */
    public ResultSet consultar() throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement consultar = conexion.createStatement();
        return consultar.executeQuery("SELECT * FROM Asignaturas");
    }    
}
