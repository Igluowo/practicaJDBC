/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicajdbc.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erick
 */
public class FamiliarRepositorio {

    private Connection conexion;

    public FamiliarRepositorio(Connection conexion) {
        this.conexion = conexion;
    }

    
}
