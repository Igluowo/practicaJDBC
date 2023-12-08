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
public class FamiliarRepositorio {
    public FamiliarRepositorio() {}
    
    /* EjercicioD (iii): Insertar */
    public void insertarFamiliar(int idAlumno, String nombre, String sexo, int telefono, boolean custodia) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement insertar = conexion.createStatement();
        String custodiaString = "";
        if (custodia) {
            custodiaString = "S";
        }else{
            custodiaString = "N";
        }
        insertar.executeUpdate("INSERT INTO Familiar VALUES(" + idAlumno + ", '" + nombre + "', '" + sexo + "', '" 
                + telefono + "', '" + custodiaString + "')");
    }
    
    /* EjercicioE (ii): Actualizar */
    public void actualizarCustodia(int id, String custodia) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement actualizar = conexion.createStatement();
        actualizar.executeUpdate("update Familiar\n"
                + "set custodia = '" + custodia + "'\n" 
                + "where id = " + id);
    }
    
    /* EjercicioG: Consultar */
    public ResultSet consultar() throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement consultar = conexion.createStatement();
        return consultar.executeQuery("SELECT * FROM Familiar");
    }
}
