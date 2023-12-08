/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc.repositories;

import com.mycompany.practicajdbc.connection.ConexionBase;
import com.mycompany.practicajdbc.entities.Alumno;
import com.mycompany.practicajdbc.entities.Direccion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class AlumnoRepositorio {

    public AlumnoRepositorio() {
    }

    /* EjercicioC (i): Consultar */
    public ResultSet consultarAlumno(String nombre) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement consultar = conexion.createStatement();
        return consultar.executeQuery("SELECT * FROM ALUMNOS where nombre = '" + nombre + "'");
    }

    /* EjercicioC (ii): Consultar */
    public ResultSet consultarAlumnos() throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement consultar = conexion.createStatement();
        return consultar.executeQuery("SELECT * FROM ALUMNOS");
    }

    /* EjercicioC (iii): Consultar */
    public ResultSet consultarAlumnosCustodia(String nombre) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement consultar = conexion.createStatement();
        return consultar.executeQuery("SELECT Alumnos.nombre, Familiar.custodia\n"
                + "FROM Alumnos\n"
                + "LEFT JOIN Familiar ON Alumnos.id = Familiar.IdAlumno\n"
                + "WHERE Alumnos.nombre = '" + nombre + "'");
    }

    /* EjercicioD (i): Insertar */
    public void insertarAlumno(String nombre, int telefono, String direccion) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement insertar = conexion.createStatement();
        insertar.executeUpdate("INSERT INTO ALUMNOS VALUES('" + nombre + "', '" + telefono + "', '" + direccion + "')");
    }

    /* EjercicioF (i): Eliminar */
    public void eliminarAlumno(int idAlumno) throws SQLException {
        ConexionBase controlador = new ConexionBase();
        Connection conexion = controlador.conectar();
        Statement eliminar = conexion.createStatement();
        eliminar.executeUpdate("alter table Asignaturas\n"
                + "drop constraint FK_idAlumno_Asi\n"
                + "alter table Direccion\n"
                + "drop constraint FK_idAlumno_dir\n"
                + "alter table Familiar\n"
                + "drop constraint FK_idAlumno_Fam\n"
                + "DELETE FROM ALUMNOS where id = " + idAlumno + "\n"
                + "alter table Asignaturas\n"
                + "add constraint FK_idAlumno_Asi FOREIGN KEY (id)\n"
                + "REFERENCES nombre_tabla_referencia (idAlumno);"
                + "alter table Direccion\n"
                + "add constraint FK_idAlumno_dir FOREIGN KEY (id)\n"
                + "REFERENCES nombre_tabla_referencia (idAlumno);"
                + "alter table Familiar\n"
                + "add constraint FK_idAlumno_Fam FOREIGN KEY (id)\n"
                + "REFERENCES nombre_tabla_referencia (idAlumno);");
    }
}
