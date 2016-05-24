package com.mycompany.sokoban3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author ikor
 */

public class MainApp extends Application {

    /**
     * 
     * @param stage
     * @throws Exception 
     */
    
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
    	Pane parent = loader.load(getClass().getResource("/fxml/Scene.fxml").openStream());
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Sokoban");
		stage.show();
    }
    
    /**
     * 
     * @param args 
     */

    public static void main(String[] args) {
        launch(args);
    }

}
