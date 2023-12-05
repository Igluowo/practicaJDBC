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
public class FamiliarRepositorio {
    
    public void insertarAlumno(int idAlumno, String nombre, String sexo, int telefono, boolean custodia) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement insertar = conexion.createStatement();
        String custodiaString = "";
        if (custodia) {
            custodiaString = "S";
        }else{
            custodiaString = "N";
        }
        insertar.executeUpdate("INSERT INTO Familiares VALUES(" + idAlumno + ", '" + nombre + "', '" + sexo + "', '" 
                + telefono + "', '" + custodiaString + "')");
    }
}
