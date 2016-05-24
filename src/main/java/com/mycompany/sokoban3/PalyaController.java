/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sokoban3;

import com.mycompany.db.Felhasznalo;
import com.mycompany.db.AdatbazisKapcsolat;
import java.awt.Canvas;
//import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Laczka Zoltan
 */
public class PalyaController implements Initializable {

    int aktualx;
    int aktualy;
    int szamlalo = 0;
    String jatekos;
    String[][] m = new String[6][6];
    String[][] meredeti = new String[6][6];

    ArrayList<String> listaf = new ArrayList();
    @FXML
    public Button vissza;

    @FXML
    public Label label;

    @FXML
    public Canvas button;

    @FXML
    public GridPane gridpane;

    @FXML
    public Button le;

    @FXML
    public Button fel;

    @FXML
    public Button jobb;

    @FXML
    public Button bal;

    /**
     * when the button is pushed change the scene to an other which was before
     * it
     *
     * @param event get an event
     * @throws IOException
     */
    @FXML
    private void visszaaction(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        stage = (Stage) vissza.getScene().getWindow();

        //root = FXMLLoader.load(getClass().getResource("/fxml/Scene2.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = (Parent) loader.load();
        loader.<FXMLController>getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        //scene.getStylesheets().add("/styles/Styles.css");
        stage.show();
    }

    /**
     *when the button is pushed the player try to move down in the board
     * @param event get an event 
     * @throws IOException
     */

    @FXML
    private void le(ActionEvent event) throws IOException {

        if (m[4][4].equals("B") && m[1][4].equals("B")) {
            Stage stage;
            Parent root;

            stage = (Stage) le.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLWin.fxml"));
            root = (Parent) loader.load();
            loader.<FXMLWinController>getController().setFelhasznalo(jatekos);
            loader.<FXMLWinController>getController().setPontszam(String.valueOf(szamlalo));

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();

        } else {

            Stage stage;
            Parent root;

            stage = (Stage) le.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/palya.fxml"));
            root = (Parent) loader.load();
            loader.<FXMLController>getController();

            PalyaController lepesle = (PalyaController) loader.getController();
            label.setText(jatekos);
            lepesle.lelep(m, jatekos, szamlalo);

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        }
    }

    /**
     * when the button is pushed the player try to move left in the board
     * @param event get an event
     * @throws IOException
     */

    @FXML
    private void bal(ActionEvent event) throws IOException {

        if (m[4][4].equals("B") && m[1][4].equals("B")) {
            Stage stage;
            Parent root;

            stage = (Stage) bal.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLWin.fxml"));
            root = (Parent) loader.load();
            loader.<FXMLController>getController();
            loader.<FXMLWinController>getController().setFelhasznalo(jatekos);
            loader.<FXMLWinController>getController().setPontszam(String.valueOf(szamlalo));

            label.setText(jatekos);
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } else {

            Stage stage;
            Parent root;

            stage = (Stage) le.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/palya.fxml"));
            root = (Parent) loader.load();
            loader.<FXMLController>getController();

            PalyaController lepesle = (PalyaController) loader.getController();
            lepesle.ballep(m, jatekos, szamlalo);

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        }
    }
    
    /**
     * when the button is pushed the player try to move right in the board
     * @param event get an event 
     * @throws IOException 
     */

    @FXML
    private void jobb(ActionEvent event) throws IOException {

        if (m[4][4].equals("B") && m[1][4].equals("B")) {
            Stage stage;
            Parent root;

            stage = (Stage) jobb.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLWin.fxml"));
            root = (Parent) loader.load();
            loader.<FXMLController>getController();
            loader.<FXMLWinController>getController().setFelhasznalo(jatekos);
            loader.<FXMLWinController>getController().setPontszam(String.valueOf(szamlalo));

            label.setText(jatekos);
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } else {
            Stage stage;
            Parent root;

            stage = (Stage) le.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/palya.fxml"));
            root = (Parent) loader.load();
            loader.<FXMLController>getController();

            PalyaController lepesle = (PalyaController) loader.getController();
            lepesle.jobblep(m, jatekos, szamlalo);

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        }
    }
    /**
     * when the button is pushed the player try to move up in the board
     * @param event get an event 
     * @throws IOException 
     */

    @FXML
    private void fel(ActionEvent event) throws IOException {

        if (m[4][4].equals("B") && m[1][4].equals("B")) {
            Stage stage;
            Parent root;

            stage = (Stage) fel.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FXMLWin.fxml"));
            root = (Parent) loader.load();
            loader.<FXMLController>getController();
            loader.<FXMLWinController>getController().setFelhasznalo(jatekos);
            loader.<FXMLWinController>getController().setPontszam(String.valueOf(szamlalo));

            label.setText(jatekos);
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } else {

            Stage stage;
            Parent root;

            stage = (Stage) le.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/palya.fxml"));
            root = (Parent) loader.load();
            loader.<FXMLController>getController();

            PalyaController lepesle = (PalyaController) loader.getController();
            lepesle.fellep(m, jatekos, szamlalo);

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        }
    }

    /**
     * 
     * Get details about the player and the board
     * @param nev get the name of the player
     * @param mp get the board structure
     * @param aktx get the position x of player in the board
     * @param akty get the position x of player in the board
     */
    public void nev(String nev, String[][] mp, int aktx, int akty) {
        label.setText(nev);
        jatekos = nev;

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                gridpane.add(alakit(mp[i][j]), i, j);

            }

        }

        m = mp;
        aktualx = aktx;
        aktualy = akty;
        meredeti = mp;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                System.out.println(i + " " + j + " " + meredeti[i][j]);
            }
        }
    }

    /**
     * Here are the conditions about moving down
     * @param m1 get the board
     * @param jatek get the name of the player
     * @param szam get the number of his\her steps
     */
    public void lelep(String[][] m1, String jatek, int szam) {
        boolean valt = true;
        int x = 0;
        int y = 0;
        label.setText(jatek);
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (m1[i][j].equals("P")) {
                    x = i;
                    y = j;
                }

            }
        }

        if (m1[x][y + 1].equals("B")) {
            valt = false;
            if (!m1[x][y + 2].equals("B")) {
                valt = false;
                if (!m1[x][y + 2].equals("W")) {
                    m1[x][y] = "S";
                    m1[x][y + 1] = "P";
                    m1[x][y + 2] = "B";
                    szam++;
                }
            }

        }

        if (!m1[x][y + 1].equals("W") && valt) {
            m1[x][y] = "S";
            m1[x][y + 1] = "P";
            szam++;
        }
        if (!m1[1][4].equals("P") && !m1[1][4].equals("B")) {
            m1[1][4] = "C";
        }
        if (!m1[4][4].equals("P") && !m1[4][4].equals("B")) {
            m1[4][4] = "C";
        }
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                gridpane.add(alakit(m1[i][j]), i, j);

            }

        }

        m = m1;
        jatekos = jatek;
        szamlalo = szam;
    }

    /**
     * Here are the conditions about moving right
     * @param m1 get the board
     * @param jatek get the name of the player
     * @param szam get the number of his\her steps
     */
    
    public void jobblep(String[][] m1, String jatek, int szam) {
        int x = 0;
        int y = 0;
        label.setText(jatek);
        boolean valt = true;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (m1[i][j].equals("P")) {
                    x = i;
                    y = j;
                }

            }
        }

        if (m1[x + 1][y].equals("B")) {
            valt = false;
            if (!m1[x + 2][y].equals("B")) {
                valt = false;
                if (!m1[x + 2][y].equals("W")) {
                    m1[x][y] = "S";
                    m1[x + 1][y] = "P";
                    m1[x + 2][y] = "B";
                    szam++;
                }
            }

        }

        if (!m1[x + 1][y].equals("W") && valt) {
            m1[x][y] = "S";
            m1[x + 1][y] = "P";
            valt = false;
            szam++;
        }

        if (!m1[1][4].equals("P") && !m1[1][4].equals("B")) {
            m1[1][4] = "C";
        }
        if (!m1[4][4].equals("P") && !m1[4][4].equals("B")) {
            m1[4][4] = "C";
        }

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                gridpane.add(alakit(m1[i][j]), i, j);

            }

        }

        m = m1;
        jatekos = jatek;
        szamlalo = szam;
    }

    /**
     * Here are the conditions about moving left
     * @param m1 get the board
     * @param jatek get the name of the player
     * @param szam get the number of his\her steps
     */
    public void ballep(String[][] m1, String jatek, int szam) {
        int x = 0;
        int y = 0;
        label.setText(jatek);
        boolean valt = true;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (m1[i][j].equals("P")) {
                    x = i;
                    y = j;
                }

            }
        }

        if (m1[x - 1][y].equals("B")) {
            valt = false;
            if (!m1[x - 2][y].equals("B")) {
                valt = false;
                if (!m1[x - 2][y].equals("W")) {
                    m1[x][y] = "S";
                    m1[x - 1][y] = "P";
                    m1[x - 2][y] = "B";
                    szam++;

                }
            }

        }

        if (!m1[x - 1][y].equals("W") && valt) {
            m1[x][y] = "S";
            m1[x - 1][y] = "P";
            szam++;
        }
        if (!m1[1][4].equals("P") && !m1[1][4].equals("B")) {
            m1[1][4] = "C";
        }
        if (!m1[4][4].equals("P") && !m1[4][4].equals("B")) {
            m1[4][4] = "C";
        }
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                gridpane.add(alakit(m1[i][j]), i, j);

            }

        }

        m = m1;
        jatekos = jatek;
        szamlalo = szam;
    }

    /**
     * Here are the conditions about moving up
     * @param m1 get the board
     * @param jatek get the name of the player
     * @param szam get the number of his\her steps
     */
    public void fellep(String[][] m1, String jatek, int szam) {
        int x = 0;
        int y = 0;
        label.setText(jatek);
        boolean valt = true;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (m1[i][j].equals("P")) {
                    x = i;
                    y = j;
                }

            }
        }

        if (m1[x][y - 1].equals("B")) {
            valt = false;
            if (!m1[x][y - 2].equals("B")) {
                valt = false;
                if (!m1[x][y - 2].equals("W")) {
                    m1[x][y] = "S";
                    m1[x][y - 1] = "P";
                    m1[x][y - 2] = "B";
                    szam++;

                }
            }

        }

        if (!m1[x][y - 1].equals("W") && valt) {
            m1[x][y] = "S";
            m1[x][y - 1] = "P";
            szam++;
        }
        if (!m1[1][4].equals("P") && !m1[1][4].equals("B")) {
            m1[1][4] = "C";
        }
        if (!m1[4][4].equals("P") && !m1[4][4].equals("B")) {
            m1[4][4] = "C";
        }
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                gridpane.add(alakit(m1[i][j]), i, j);

            }

        }

        m = m1;

        jatekos = jatek;

        szamlalo = szam;

    }
   
    /**
     * 
     * Change a String type to a text type
     * @param n is the unity of the board
     * @return a text type
     */

    public Text alakit(String n) {
        Text text = new Text(n);
        return text;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
