/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.App;
import com.mycompany.practicajdbc.connection.ConexionBase;
import com.mycompany.practicajdbc.repositories.AlumnoRepositorio;
import com.mycompany.practicajdbc.repositories.AsignaturaRepositorio;
import com.mycompany.practicajdbc.repositories.DireccionRepositorio;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class EjercicioFController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonEliminar;

    @FXML
    private TextField fieldAlumno;

    @FXML
    private TextField fieldAsignatura;

    @FXML
    void cancelar(ActionEvent event) throws IOException {
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

    @FXML
    void comprobarVacio(KeyEvent event) {
        if (!fieldAlumno.getText().isEmpty()) {
            botonEliminar.setDisable(false);
        } else {
            botonEliminar.setDisable(true);
        }
    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {
        try {
            if (fieldAsignatura.getText().isEmpty()) {
                String idAlumnoString = fieldAlumno.getText();
                int idAlumno = Integer.parseInt(idAlumnoString);
                AlumnoRepositorio alumnoRepo = new AlumnoRepositorio();
                DireccionRepositorio direccionRepo = new DireccionRepositorio();
                alumnoRepo.eliminarAlumno(idAlumno);
                direccionRepo.eliminarDireccion(idAlumno);
                alerta();
            } else {
                String idAlumnoString = fieldAlumno.getText();
                int idAlumno = Integer.parseInt(idAlumnoString);
                String idAsignaturaString = fieldAsignatura.getText();
                int idAsignatura = Integer.parseInt(idAsignaturaString);
                AsignaturaRepositorio repositorio = new AsignaturaRepositorio();
                repositorio.eliminarAsignatura(idAlumno, idAsignatura);
                alerta();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("[!] Ha ocurrido un error, verifique los id e intentelo de nuevo");
            alert.showAndWait();
        }
    }

    private void alerta() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("[i] Se han eliminado los registros con éxito");
        alert.showAndWait();
    }

}
