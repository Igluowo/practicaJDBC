/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.connection.ConexionBase;
import com.mycompany.practicajdbc.repositories.FamiliarRepositorio;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
        sexo.getItems().addAll("Masculino", "Femenino");
        sexo.setValue("Masculino");
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
    private ComboBox<String> sexo;

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
        } else {
            etiqueta.setVisible(false);
            botonInsertar.setDisable(false);
        }
    }

    @FXML
    void insertar(ActionEvent event) {
        String idAlumnoString = fieldAlumno.getText();
        int idAlumno = Integer.parseInt(idAlumnoString);
        String nombre = fieldNombre.getText();
        String telefonoString = fieldTelefono.getText();
        String sexoString = sexo.getValue();
        FamiliarRepositorio repositorio = new FamiliarRepositorio();
        try {
            int telefono = Integer.parseInt(telefonoString);
            repositorio.insertarFamiliar(idAlumno, nombre, sexoString, telefono, custodia.isSelected());
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Se ha realizado correctamente");
            alerta.setContentText("[i] Se ha insertado el familiar correctamente");
            alerta.showAndWait();
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("[!] Error de conexion, intentelo de nuevo");
            alert.showAndWait();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("[!] El telefono debe ser valido, deben ser 9 digitos y ser numeros");
            alert.showAndWait();
        }
    }
}
