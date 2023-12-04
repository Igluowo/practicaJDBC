/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.connection.ConexionBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class EjercicioBController implements Initializable {

    public int tablaBorrada = 0;

    @FXML
    private Button botonAlu;

    @FXML
    private Button botonAsi;

    @FXML
    private Button botonDir;

    @FXML
    private Button botonFam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void eliminarTabla(ActionEvent event) throws SQLException {
        String tabla = "";
        String foranea = "";
        if (event.getSource().equals(botonAsi)) {
            tabla = "Asignaturas";
            foranea = "Asi";
        } else if (event.getSource().equals(botonDir)) {
            tabla = "Direccion";
            foranea = "Dir";
        } else if (event.getSource().equals(botonFam)) {
            tabla = "Familiar";
            foranea = "Fam";
        } else {
            tabla = "alumno";
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("[i] ¿Está seguro que quiere borrar?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                ConexionBase controlador = new ConexionBase();
                Connection conexion = controlador.conectar();
                controlador.eliminarTabla(conexion, tabla, foranea);
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setTitle("Se ha realizado correctamente");
                alerta.setContentText("[i] Se ha borrado la tabla");
                alerta.showAndWait();
                tablaBorrada++;
            } catch (SQLException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("[!] Esta tabla ya ha sido borrada");
                alerta.showAndWait();
            }
        }
        if (tablaBorrada == 3) {
            botonAlu.setDisable(false);
        }
    }

    @FXML
    void salir(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
