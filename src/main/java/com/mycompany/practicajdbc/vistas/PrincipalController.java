/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practicajdbc.vistas;

import com.mycompany.practicajdbc.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 2damb
 */
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Parent root;
    private Stage escena;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Button botonA;

    @FXML
    private MenuItem Salir;

    @FXML
    void cambiarA(ActionEvent event) throws IOException {
        FXMLLoader escena = new FXMLLoader(App.class.getResource("EjercicioA.fxml"));
        Parent looker = escena.load();
        Scene scene = new Scene(looker);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cambiarB(ActionEvent event) throws IOException {
        FXMLLoader escena = new FXMLLoader(App.class.getResource("EjercicioB.fxml"));
        Parent looker = escena.load();
        Scene scene = new Scene(looker);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cambiarC(ActionEvent event) {

    }

    @FXML
    void cambiarD(ActionEvent event) throws IOException {
        FXMLLoader escena = new FXMLLoader(App.class.getResource("EjercicioD.fxml"));
        Parent looker = escena.load();
        Scene scene = new Scene(looker);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cambiarE(ActionEvent event) {

    }

    @FXML
    void cambiarF(ActionEvent event) {

    }

    @FXML
    void cambiarG(ActionEvent event) {

    }

    @FXML
    void Salir(ActionEvent event) {
        System.exit(0);
    }

}
