/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.repositories.DireccionRepositorio;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class RegistrarDireccionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Button botonInsertar;

    @FXML
    private Label etiqueta;

    @FXML
    private TextField fieldDireccion;

    @FXML
    private TextField fieldId;

    @FXML
    void cancelar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void comprobarVacio(KeyEvent event) {
        if (fieldId.getText().equals("") || fieldDireccion.getText().equals("")) {
            etiqueta.setVisible(true);
            botonInsertar.setDisable(true);
        } else {
            etiqueta.setVisible(false);
            botonInsertar.setDisable(false);
        }
    }

    @FXML
    void insertar(ActionEvent event) {
        String idAlumnoString = fieldId.getText();
        int idAlumno = Integer.parseInt(idAlumnoString);
        String direccion = fieldDireccion.getText();
        DireccionRepositorio direcciones = new DireccionRepositorio();
        try {
            direcciones.insertarDireccion(direccion, idAlumno);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("[!] El id de alumno no existe en la tabla");
            alert.showAndWait();
        }
    }

}
