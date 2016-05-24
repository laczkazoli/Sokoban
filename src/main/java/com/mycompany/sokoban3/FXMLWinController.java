/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sokoban3;

import com.mycompany.db.Felhasznalo;
import com.mycompany.db.AdatbazisKapcsolat;
import com.mycompany.db.FelhasznaloDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Laczka Zoltan
 */
public class FXMLWinController implements Initializable {


    ArrayList<String> ered = new ArrayList<>();
    ArrayList<String> felhasznal = new ArrayList<>();
    String neve;

    @FXML
    private Label pontszamlabel;

    @FXML
    private Button kilepes;

    @FXML
    private Button eredmeny;

    @FXML
    ListView<Felhasznalo> listview;

    String felhasznalonev;
    String pontszam;

    @FXML
    private void kilepes(ActionEvent event) {

        Platform.exit();
    }

    @FXML
    private void eredmeny(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        stage = (Stage) eredmeny.getScene().getWindow();

        //root = FXMLLoader.load(getClass().getResource("/fxml/Scene2.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLEredmeny.fxml"));
        root = (Parent) loader.load();
        //FXMLEredmenyController ize = (FXMLEredmenyController) loader.getController();

        Scene scene = new Scene(root);

        loader.<FXMLEredmenyController>getController().setFelhasznalo(felhasznalonev);
        loader.<FXMLEredmenyController>getController().setPontszam(pontszam);
        loader.<FXMLEredmenyController>getController().highscorekiir();
        stage.setOnCloseRequest(e->AdatbazisKapcsolat.close());
        stage.setScene(scene);
        //scene.getStylesheets().add("/styles/Styles.css");
        stage.show();
    }

    public void setFelhasznalo(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public void setPontszam(String pontszam) {
        this.pontszam = pontszam;
    }

    public void pont(String a, String b) {
        pontszamlabel.setText(a);
        neve = b;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
