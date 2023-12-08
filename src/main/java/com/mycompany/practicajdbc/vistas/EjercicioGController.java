/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.App;
import com.mycompany.practicajdbc.entities.Alumno;
import com.mycompany.practicajdbc.entities.Asignatura;
import com.mycompany.practicajdbc.entities.Direccion;
import com.mycompany.practicajdbc.entities.Familiar;
import com.mycompany.practicajdbc.repositories.AlumnoRepositorio;
import com.mycompany.practicajdbc.repositories.AsignaturaRepositorio;
import com.mycompany.practicajdbc.repositories.DireccionRepositorio;
import com.mycompany.practicajdbc.repositories.FamiliarRepositorio;
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
public class EjercicioGController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        consulta.getItems().addAll("Familiar", "Dirección", "Asignatura");
        consulta.setValue("Familiar");
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
    void consultar(ActionEvent event) {
        try {
            String consultaString = consulta.getValue();
            if (consultaString.equals("Familiar")) {
                ArrayList<Familiar> resultados = new ArrayList<>();
                String resultadoConsulta = "Familiar: ";
                FamiliarRepositorio repositorio = new FamiliarRepositorio();
                ResultSet resultado = repositorio.consultar();
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    int idAlumno = resultado.getInt("idAlumno");
                    String nombre = resultado.getString("nombre");
                    String sexo = resultado.getString("sexo");
                    int telefono = resultado.getInt("telefono");
                    char custodiaChar = resultado.getString("custodia").charAt(0);
                    boolean custodia = (custodiaChar == 'S');
                    Familiar familiar = new Familiar(id, idAlumno, nombre, sexo, telefono, custodia);
                    resultados.add(familiar);
                }
                for (Familiar familiar : resultados) {
                    resultadoConsulta += "\n----------------------------\n" + familiar.toString() + "\n----------------------------\n";
                }
                areaResultados.setText(resultadoConsulta);
                resultados.clear();
            } else if (consultaString.equals("Dirección")) {
                ArrayList<Direccion> resultados = new ArrayList<>();
                String resultadoConsulta = "Direccion: ";
                DireccionRepositorio repositorio = new DireccionRepositorio();
                ResultSet resultado = repositorio.consultar();
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    int idAlumno = resultado.getInt("idAlumno");
                    String direccionString = resultado.getString("direccion");
                    Direccion direccion = new Direccion(id, idAlumno, direccionString);
                    resultados.add(direccion);
                }
                for (Direccion direccion : resultados) {
                    resultadoConsulta += "\n----------------------------\n" + direccion.toString() + "\n----------------------------\n";
                }
                areaResultados.setText(resultadoConsulta);
                resultados.clear();
            } else {
                ArrayList<Asignatura> resultados = new ArrayList<>();
                String resultadoConsulta = "Asignatura: ";
                AsignaturaRepositorio repositorio = new AsignaturaRepositorio();
                ResultSet resultado = repositorio.consultar();
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    int idAlumno = resultado.getInt("idAlumno");
                    String nombre = resultado.getString("nombre");
                    String curso = resultado.getString("curso");
                    int nota = resultado.getInt("nota");
                    Asignatura asignatura = new Asignatura(id, idAlumno, nombre, curso, nota);
                    resultados.add(asignatura);
                }
                for (Asignatura asignatura : resultados) {
                    resultadoConsulta += "\n----------------------------\n" + asignatura.toString() + "\n----------------------------\n";
                }
                areaResultados.setText(resultadoConsulta);
                resultados.clear();
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
}
