/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package poli.Views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
/**
 *
 * @author subti
 */
public class MainView extends Application implements Initializable {
    @FXML
    private Canvas canvas;
    
    private double centerX;
    private double centerY;
    private double angle;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        //System.out.println(getClass());
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Vuelo de los Estorninos");
        
        scene = (Scene)FXMLLoader.load(getClass().getResource("MainView.fxml"));
        //root. = root.load();
        
        //Scene scene = new Scene(root, 800, 600);

        // Configurar el escenario principal (Stage)
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Vuelo de los Estorninos");
        primaryStage.setResizable(true);

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
        centerX = canvas.getWidth() / 2.0;
        centerY = canvas.getHeight() / 2.0;
        angle = 0.0;

        // Crear la animación para actualizar el punto en cada fotograma
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            update();
            draw();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void update() {
        angle += 0.05;
        if (angle > 2 * Math.PI) {
            angle -= 2 * Math.PI;
        }
    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2.0 - 5;
        double x = centerX + radius * Math.cos(angle);
        double y = centerY + radius * Math.sin(angle);

        gc.setFill(Color.RED);
        gc.fillOval(x - 5, y - 5, 10, 10);
    }
    
}
