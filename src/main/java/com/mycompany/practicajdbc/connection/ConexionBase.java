/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc.connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author erick
 */
public class ConexionBase {

    public ConexionBase() {
    }

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

    /* Ejercicio A: Creacion de tablas */
    public void crearTablas(Connection conexion) {
        try {
            reciclarCrear(conexion, false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("[i] La tablas se han creado correctamente");
            alert.showAndWait();
        } catch (SQLException e) {
            try {
                reciclarCrear(conexion, true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("[i] La tablas se han creado correctamente");
                alert.showAndWait();
            } catch (SQLException b) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("[!] Ha ocurrido un error con la creación de las tablas, intente de nuevo ");
                alert.showAndWait();
            }
        }
    }

    //Método para evitar errores en la creación
    public void reciclarCrear(Connection conexion, boolean error) throws SQLException {
        String borrarForaneas = "alter table Asignaturas\n"
                + "drop constraint FK_idAlumno_Asi\n"
                + "alter table Direccion\n"
                + "drop constraint FK_idAlumno_dir\n"
                + "alter table Familiar\n"
                + "drop constraint FK_idAlumno_Fam\n";
        String borradoTablas = "drop table if exists Alumnos\n"
                + "drop table if exists Asignaturas\n"
                + "drop table if exists Direccion\n"
                + "drop table if exists Familiar\n";
        String tablaAlumno = "CREATE TABLE Alumnos(id int primary key identity, "
                + "nombre varchar(50) not null, telefono char(9) not null, direccion varchar(200) not null)\n";
        String tablaAsignatura = "CREATE TABLE Asignaturas(id int primary key identity, idAlumno int, nombre varchar(50), "
                + "curso varchar(20), notas int, constraint FK_idAlumno_Asi Foreign key (idAlumno) references Alumnos(id))";
        String tablaDireccion = "create table Direccion(\n" + "id int primary key identity,\n" + "idAlumno int,\n"
                + "direccion varchar(200),\n"
                + "constraint FK_idAlumno_dir Foreign key (idAlumno) references Alumnos(id)\n"
                + ")";
        String tablaFamiliar = "create table Familiar(id int primary key identity, idAlumno int, "
                + "nombre varchar(50), sexo varchar(20), telefono char(9), custodia char(1),\n"
                + "constraint FK_idAlumno_Fam Foreign key (idAlumno) references Alumnos(id))\n";
        if (error) {
            PreparedStatement crear = conexion.prepareStatement(borradoTablas + tablaAlumno + tablaAsignatura
                    + tablaDireccion + tablaFamiliar);
            crear.execute();
        } else {
            PreparedStatement crear = conexion.prepareStatement(borrarForaneas + borradoTablas + tablaAlumno + tablaAsignatura
                    + tablaDireccion + tablaFamiliar);
            crear.execute();
        }
    }

    /* EjercicioB: Eliminar tablas */
    public void eliminarTabla(Connection conexion, String tabla, String foranea) throws SQLException {
        Statement eliminar = conexion.createStatement();
        String borrar = "";
        if (tabla.equals("alumno")) {
            borrar = "drop table if exists Alumnos\n";
        } else {
            borrar = "alter table " + tabla + "\n"
                    + "drop constraint FK_idAlumno_" + foranea + "\n"
                    + "drop table " + tabla + "\n";
        }
        eliminar.executeUpdate(borrar);
    }
}
