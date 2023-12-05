/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class RegistrarFamiliarController implements Initializable {

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
    private CheckBox custodia;

    @FXML
    private TextField fieldAlumno;

    @FXML
    private TextField fieldNombre;

    @FXML
    private TextField fieldTelefono;

    @FXML
    private ComboBox<?> sexo;
    
    @FXML
    private Label etiqueta;

    @FXML
    void cancelar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void comprobarVacio(KeyEvent event) {
        if (fieldAlumno.getText().equals("") || fieldNombre.getText().equals("") 
                || fieldTelefono.getText().equals("")) {
            etiqueta.setVisible(true);
            botonInsertar.setDisable(true);
        }else{
            etiqueta.setVisible(false);
            botonInsertar.setDisable(false);
        } 
    }

    @FXML
    void insertar(ActionEvent event) {

    }
}
