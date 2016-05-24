package com.mycompany.sokoban3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.db.Felhasznalo;
import com.mycompany.db.AdatbazisKapcsolat;
import com.mycompany.db.FelhasznaloDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
public class FXMLEredmenyController {

    @FXML
    private Button kilepes;

    @FXML
    ListView<Felhasznalo> listview;
    String felhasznalonev;
    String pontszam;

    public void highscorekiir() {

        FelhasznaloDAO.felhasznaloHozzaad(felhasznalonev, pontszam);
        List<Felhasznalo> felhasznalok = FelhasznaloDAO.lekerfelhasznalo();
        ObservableList<Felhasznalo> obslist = FXCollections.observableList(felhasznalok);
        listview.setItems(obslist);

    }

    public void setFelhasznalo(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public void setPontszam(String pontszam) {
        this.pontszam = pontszam;
    }

    @FXML
    private void kilepes(ActionEvent event) {

        System.exit(0);
    }

}
