/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package poli.Views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import poli.Models.Herd;
import poli.Models.Point;
/**
 *
 * @author subti
 */
public class MainView extends Application implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private Slider cantidadSlider;
    @FXML
    private Button playButton;
    
    private double centerX;
    private double centerY;
    private double angle;
    private int cantidad;
    
    private Point[] points = new Point[1000]; 
    private Herd horda;
    @Override
    public void start(Stage primaryStage) throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/
        //System.out.println(getClass());
        
        BorderPane root = new BorderPane();

        //Scene scene = new Scene(root, 800, 600);
        Scene scene = (Scene)FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Vuelo de los Estorninos");
        
        //scene = (Scene)FXMLLoader.load(getClass().getResource("MainView.fxml"));
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
        horda = new Herd();
        centerX = canvas.getWidth() / 2.0;
        centerY = canvas.getHeight() / 2.0;
        angle = 0.0;
        Random random = new Random();
        
        
        gc = canvas.getGraphicsContext2D();
        for (int i = 0; i < 1000; i++) {
            points[i] = new Point();
            //points[i].setPositionX(random.nextDouble() * centerX *2);
            //points[i].setPositionY(random.nextDouble() * centerY*2);
            points[i].InitRandomPosition(centerX* 2, centerX*2);
            
        }
        // Crear la animación para actualizar el punto en cada fotograma
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            update();
            draw();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void update() {
        angle += 0.01;
        if (angle > 2 * Math.PI) {
            angle -= 2 * Math.PI;
        }
        for (int i = 0; i < 1000; i++) {
            points[i] = new Point();
            //points[i].setPositionX(random.nextDouble() * centerX *2);
            //points[i].setPositionY(random.nextDouble() * centerY*2);
            points[i].InitRandomPosition(centerX* 2, centerX*2);
            
        }
    }
    GraphicsContext gc;
    private void draw() {
        
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2.0 - 5;
        double x1 = centerX + radius * Math.cos(angle);
        double y1 = centerY + radius * Math.sin(angle);
        
        
        gc.setFill(Color.GRAY);
        gc.fillOval(x1 - 5, y1 - 5, 10, 10);
        //ArrayList<Point> puntos = horda.getPoints();
        for(Point point:points){
            gc.fillOval(point.getPositionX() - 5, point.getPositionY() - 5, 10, 10);
        }
    }
    public void playPressed()
    {
        cantidad = (int)cantidadSlider.getValue();
	horda = new Herd();
	horda.Create(cantidad, canvas.getWidth(),canvas.getHeight());
        
    }
}
