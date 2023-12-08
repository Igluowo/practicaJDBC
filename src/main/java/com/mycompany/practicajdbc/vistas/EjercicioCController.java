/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.App;
import com.mycompany.practicajdbc.entities.Alumno;
import com.mycompany.practicajdbc.repositories.AlumnoRepositorio;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class EjercicioCController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        consulta.getItems().addAll("Consultar 3 por nombre", "Consultar todos", "Consultar 4 para custodia");
        consulta.setValue("Consultar 3 por nombre");
    }

    @FXML
    private TextArea areaResultados;

    @FXML
    private Button botonCancelar;

    @FXML
    private Button botonConsultar;

    @FXML
    private ComboBox<String> consulta;

    @FXML
    private Label etiquetaAlumnos;

    @FXML
    private TextField fieldAlumnos;

    private ArrayList<Alumno> alumnos = new ArrayList<>();

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
    void consultar(ActionEvent event) {
        try {
            String consultaString = consulta.getValue();
            if (consultaString.equals("Consultar todos")) {
                String resultadoConsulta = "Alumnos: ";
                AlumnoRepositorio repositorio = new AlumnoRepositorio();
                ResultSet resultado = repositorio.consultarAlumnos();
                crearAlumnos(resultado);
                for (Alumno alumno : alumnos) {
                    resultadoConsulta += "\n----------------------------\n" + alumno.toString() + "\n----------------------------\n";
                }
                areaResultados.setText(resultadoConsulta);
                alumnos.clear();
            } else if (consultaString.equals("Consultar 3 por nombre")) {
                String nombresString = fieldAlumnos.getText();
                String[] nombresArray = nombresString.split(",\\s*");
                String nombre1 = (nombresArray.length > 0) ? nombresArray[0] : "";
                String nombre2 = (nombresArray.length > 1) ? nombresArray[1] : "";
                String nombre3 = (nombresArray.length > 2) ? nombresArray[2] : "";
                ArrayList<String> nombres = new ArrayList<>();
                nombres.add(nombre1);
                nombres.add(nombre2);
                nombres.add(nombre3);
                for (String nombre : nombres) {
                    AlumnoRepositorio repositorio = new AlumnoRepositorio();
                    ResultSet resultado = repositorio.consultarAlumno(nombre);
                    crearAlumnos(resultado);
                }
                String resultadoConsulta = "Alumnos: ";
                for (Alumno alumno : alumnos) {
                    resultadoConsulta += "\n----------------------------\n" + alumno.toString() + "\n----------------------------\n";
                }
                areaResultados.setText(resultadoConsulta);
                alumnos.clear();
            } else {
                String nombresString = fieldAlumnos.getText();
                String[] nombresArray = nombresString.split(",\\s*");
                String nombre1 = (nombresArray.length > 0) ? nombresArray[0] : "";
                String nombre2 = (nombresArray.length > 1) ? nombresArray[1] : "";
                String nombre3 = (nombresArray.length > 2) ? nombresArray[2] : "";
                String nombre4 = (nombresArray.length > 3) ? nombresArray[3] : "";
                ArrayList<String> nombres = new ArrayList<>();
                nombres.add(nombre1);
                nombres.add(nombre2);
                nombres.add(nombre3);
                nombres.add(nombre4);
                String resultadoConsulta = "Alumnos: ";
                for (String nombre : nombres) {
                    AlumnoRepositorio repositorio = new AlumnoRepositorio();
                    ResultSet resultado = repositorio.consultarAlumnosCustodia(nombre);                   
                    while (resultado.next()) {
                        String nombreAlu = resultado.getString("nombre");
                        char custodia = resultado.getString("custodia").charAt(0);
                        resultadoConsulta += "\n----------------------------\n" 
                                + "Nombre: " + nombre + "\nCustodia: " + custodia + "\n"
                                + "\n----------------------------\n";
                    }
                }
                areaResultados.setText(resultadoConsulta);
                alumnos.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("[!] Ha ocurrido un error con la consulta, intente de nuevo");
            alert.showAndWait();
        }
    }

    private void crearAlumnos(ResultSet resultado) {
        try {
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                int telefono = resultado.getInt("telefono");
                ArrayList<String> direccion = new ArrayList<>();
                String direccionString = resultado.getString("direccion");
                direccion.add(direccionString);
                Alumno alumno = new Alumno(id, nombre, telefono, direccion);
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("[!] Ha ocurrido un error con la consulta, intente de nuevo");
            alert.showAndWait();
        }
    }

    @FXML
    void cambioConsulta(ActionEvent event) {
        if (consulta.getValue().equals("Consultar todos")) {
            etiquetaAlumnos.setVisible(false);
            fieldAlumnos.setVisible(false);
        } else {
            etiquetaAlumnos.setVisible(true);
            fieldAlumnos.setVisible(true);
        }
    }
}
