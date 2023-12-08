/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.App;
import com.mycompany.practicajdbc.repositories.AsignaturaRepositorio;
import com.mycompany.practicajdbc.repositories.FamiliarRepositorio;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class EjercicioEController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Button actualizar;

    @FXML
    private Button cancelar;

    @FXML
    private CheckBox custodia;

    @FXML
    private TextField fieldAlumno;

    @FXML
    private TextField fieldAsigID;

    @FXML
    private TextField fieldAsignatura;

    @FXML
    private TextField fieldFamiliar;

    boolean checkeado = false;

    @FXML
    void aceptar(ActionEvent event) {
        try {
            if (!(fieldAlumno.getText().isEmpty() || fieldAsigID.getText().isEmpty()
                    || fieldAsignatura.getText().isEmpty()) && fieldFamiliar.getText().isEmpty()) {
                actualizarAsignatura();
                sacarAlerta();
            } else if (!(fieldFamiliar.getText().isEmpty()) && (fieldAlumno.getText().isEmpty()
                    || fieldAsigID.getText().isEmpty() || fieldAsignatura.getText().isEmpty())) {
                actualizarAsignatura();
                sacarAlerta();
            } else {
                actualizarAsignatura();
                actualizarFamiliar();
                sacarAlerta();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("[!] Ha ocurrido un error, verifique que los id existan en la tabla");
            alert.showAndWait();
        }
    }

    private void actualizarAsignatura() throws SQLException {
        String idAlumnoString = fieldAlumno.getText();
        int idAlumno = Integer.parseInt(idAlumnoString);
        String idAsignaturaString = fieldAsigID.getText();
        int idAsignatura = Integer.parseInt(idAsignaturaString);
        String asignatura = fieldAsignatura.getText();
        AsignaturaRepositorio repositorio = new AsignaturaRepositorio();
        repositorio.actualizarAsignatura(idAlumno, idAsignatura, asignatura);
    }

    private void actualizarFamiliar() throws SQLException {
        String idFamiliarString = fieldFamiliar.getText();
        int idFamiliar = Integer.parseInt(idFamiliarString);
        String custodiaString = custodia.isSelected() ? "S" : "N";
        FamiliarRepositorio repositorio = new FamiliarRepositorio();
        repositorio.actualizarCustodia(idFamiliar, custodiaString);
    }

    private void sacarAlerta() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText("[i] Se ha realizado la actualización con éxito");
        alert.showAndWait();
    }

    @FXML
    void comprobarVacio(KeyEvent event) {
        if (!(fieldAlumno.getText().isEmpty() || fieldAsigID.getText().isEmpty() || fieldAsignatura.getText().isEmpty())
                || !(fieldFamiliar.getText().isEmpty())) {
            actualizar.setDisable(false);
        } else {
            actualizar.setDisable(true);
        }
    }

    @FXML
    void salir(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        FXMLLoader escena = new FXMLLoader(App.class.getResource("principal.fxml"));
        Parent looker = escena.load();
        Scene scene = new Scene(looker);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
