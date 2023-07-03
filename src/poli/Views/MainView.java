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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import poli.Models.Herd;
import poli.Models.MovingPoint;
import poli.Models.Point;
import poli.Models.Starling;
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
    private final int MAX_STARLINGS = 10000;
    
    private Starling[] starlings = new Starling[MAX_STARLINGS]; 
    private Herd horda;
    private Image image;
    @FXML
    private ImageView imageView;
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
        //String path = getClass().getClass().getResourceAsStream(
        image = new Image("poli/Assets/images/b.jpg");
        imageView.setImage(image);
        centerX = canvas.getWidth() / 2.0;
        centerY = canvas.getHeight() / 2.0;
        double maxX = canvas.getWidth();
        double maxY = canvas.getHeight();
        angle = 0.0;
        Random random = new Random();
        //horda = new Herd<Starling>(MAX_STARLINGS);
        //horda.Create(maxX,maxY,random );
        
        cantidadSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            cantidad = (int)cantidadSlider.getValue();
            // Realiza las acciones que desees con el nuevo valor del slider
        });
        
        
        
        gc = canvas.getGraphicsContext2D();
        //gc.drawImage(image, 0, 0);
        //starlings = (Starling[]) horda.getBirds();
        for (int i = 0; i < MAX_STARLINGS-1; i++) {
            starlings[i] = new Starling(random);
            starlings[i].InitRandomPosition(maxX, maxY);
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
        for (int i = 0; i < cantidad-1; i++) {
            //movingPoints[i] = new MovingPoint();
            //points[i].setPositionX(random.nextDouble() * centerX *2);
            //points[i].setPositionY(random.nextDouble() * centerY*2);
            //movingPoints[i].InitRandomPosition(centerX* 2, centerX*2);
            starlings[i].NextPosition();
        }
    }
    GraphicsContext gc;
    private void draw() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(image, 0, 0);
        double radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2.0 - 5;
        
        double x1 = centerX + radius * Math.cos(angle);
        double y1 = centerY + radius * Math.sin(angle);
        
        
        
        gc.fillOval(x1 - 5, y1 - 5, 10, 10);
        for (int i = 0; i < cantidad-1; i++) {
            gc.setFill(starlings[i].getColor());          
            gc.fillOval(starlings[i].getPositionX() - 5, starlings[i].getPositionY() - 5, 3, 3);
        }
    }
    @FXML
    public void playPressed()
    {
        cantidad = (int)cantidadSlider.getValue();        
    }
}
