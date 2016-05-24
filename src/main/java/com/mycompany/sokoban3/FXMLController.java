package com.mycompany.sokoban3;


import com.mycompany.db.Felhasznalo;
import com.mycompany.db.AdatbazisKapcsolat;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    
    int aktualx=0;
    int aktualy=0;
    
    @FXML
    public Button start_game;
    
    @FXML
    public Button quit;
    
    @FXML
    public TextField playerName;
    

    
  @FXML
     private void startHandleButtonAction(ActionEvent event) throws IOException {
       
     Stage stage;
        Parent root;

        stage = (Stage) start_game.getScene().getWindow();

        //root = FXMLLoader.load(getClass().getResource("/fxml/Scene2.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/palya.fxml"));
        root = (Parent) loader.load();
        loader.<FXMLController>getController();
        
         PalyaController nev = (PalyaController) loader.getController();
         
         
         String[][] m=new String[6][6]; 
         for(int i=0;i<6;i++)
             for(int j=0;j<6;j++)
             {
                 if(i==0 || j==0 || i==5 || j==5)
                     m[i][j]="W";
                 else 
                     m[i][j]="S";
             }
        m[1][1]="P";   
        m[1][4]="C";
        m[3][2]="W";
        m[2][3]="B";
        m[3][4]="B";
        m[4][4]="C";
        
        nev.nev(playerName.getText(),m,aktualx,aktualy);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    //scene.getStylesheets().add("/styles/Styles.css");
        stage.show(); 
    }
     
     @FXML
    private void quitHandleButtonAction(ActionEvent event) {
    	Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    

}
