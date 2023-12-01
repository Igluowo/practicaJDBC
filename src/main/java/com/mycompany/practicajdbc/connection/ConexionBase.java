/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc.connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */
public class ConexionBase {
    public ConexionBase() {}
    
    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://igluser.database.windows.net\\prueba:1433;databaseName=SwapSnap;encrypt=true;trustServerCertificate=true;",
                    "iglu", "30606933Eri");
            System.out.println("Conexion exitosa");
            return conexion;
        } catch (SQLException ex) {
            System.out.println("conexion Fallida");
            Logger.getLogger(ConexionBase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }  
    
    public ResultSet datosTabla(Connection conexion) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from Usuarios");
        return resultado;
    }
    
    public ResultSet datosProductos(Connection conexion) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from Productos");
        return resultado;
    }
    
    public ResultSet obtenerUsuario(Connection conexion, String usuario) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from usuarios where usuario == '" + usuario + "'");
        return resultado;
    }
    
    public ResultSet obtenerProductoUsuario(Connection conexion, int id) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from Productos where idUsuario == '" + id + "'");
        return resultado;
    }
    
    public ResultSet obtenerProducto(Connection conexion, int id) throws SQLException {
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("Select * from Productos where id == '" + id + "'");
        return resultado;
    }
    
    
    public void cambiarClave(Connection conexion, String usuario, String nuevaClave) throws SQLException {
        Statement consulta = conexion.createStatement();
        consulta.executeQuery("Update Usuarios set clave = " + nuevaClave + " where usuario = " + usuario);
    }
    
    public void editarProducto(Connection conexion, String campo, String nuevoDato, int idUsuario) throws SQLException {
        Statement consulta = conexion.createStatement();
        consulta.executeQuery("Update Productos set " + campo + " = " + nuevoDato + " where idUsuario = " + idUsuario);
    }
    
    public void editarEstadoProducto(Connection conexion, int idUsuario, String nombre) throws SQLException {
        Statement consulta = conexion.createStatement();
        consulta.executeQuery("Update Productos set disponible = 'false' where idUsuario = " + idUsuario 
                + " and nombre = '" + nombre + "'");
    }
    
    public void crearTablas(Connection conexion) throws SQLException {
        String tablaAlumno = "CREATE TABLE Alumnos(id integer primary key, "
                + "nombre varchar(50), telefono char(9), direccion varchar(200))";
        String tablaAsignatura = 
        PreparedStatement crear = conexion.prepareStatement("");
    }
}
