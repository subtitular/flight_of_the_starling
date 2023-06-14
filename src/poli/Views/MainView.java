/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package poli.Views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
/**
 *
 * @author subti
 */
public class MainView extends Application implements Initializable {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        //System.out.println(getClass());
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Vuelo de los Estorninos");
        
        scene = (Scene)FXMLLoader.load(getClass().getResource("MainView.fxml"));
        //root. = root.load();
        
        //Scene scene = new Scene(root, 800, 600);

        // Configurar el escenario principal (Stage)
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Vuelo de los Estorninos");
        primaryStage.setResizable(false);

        // Mostrar la ventana principal
        primaryStage.show();
        
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
