/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poli;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import poli.Views.MainView;

/**
 *
 * @author subti
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    private static Stage primaryStage = new Stage();
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Application.launch(MainView.class, args);
        //MainView view = new MainView();
        //view.start(primaryStage);
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
