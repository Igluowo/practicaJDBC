/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.App;
import com.mycompany.practicajdbc.connection.ConexionBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 2damb
 */
public class EjercicioAController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      @FXML
    private Button botonCrear;

    @FXML
    private Button botonSalir;

    @FXML
    void crearTablas(ActionEvent event) throws SQLException {
        Connection conexion = ConexionBase.conectar();
        ConexionBase crearTablas = new ConexionBase();
        crearTablas.crearTablas(conexion);
    }

    @FXML
    void salir(ActionEvent event) {
        Node source = (Node) event.getSource();   
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();   
    }
    
}
