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
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import poli.Models.Herd;
import poli.Models.MovingPoint;
import poli.Models.Point;
import poli.Models.SocialFlyingAnimal;
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
    @FXML
    private Slider leadershipSlider;
    double minLeadership =0.0;
    @FXML
    private Slider cooperationLevel;
    @FXML
    private Slider adaptabilityLevel;
    @FXML
    private Slider agilityLevel;
    @FXML
    private Slider synchronizationLevel;
    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = (Scene)FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Vuelo de los Estorninos");
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Vuelo de los Estorninos");
        primaryStage.setResizable(true);

        // Mostrar la ventana principal
        primaryStage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        image = new Image("poli/Assets/images/d.jpg");
        if (image != null) {
            double w = 0;
            double h = 0;

            double ratioX = imageView.getFitWidth() / image.getWidth();
            double ratioY = imageView.getFitHeight() / image.getHeight();

            double reducCoeff = 0;
            if(ratioY >= ratioX) {
                reducCoeff = ratioX;
            } else {
                reducCoeff = ratioX;
            }
            w = image.getWidth() * reducCoeff;
            h = image.getHeight() * reducCoeff;
            imageView.setX((imageView.getFitWidth() - w) / 2);
            imageView.setY((imageView.getFitHeight() - h) / 2);
            imageView.setImage(image);
        }
        
        centerX = canvas.getWidth() / 2.0;
        centerY = canvas.getHeight() / 2.0;
        double maxX = canvas.getWidth();
        double maxY = canvas.getHeight();
        angle = 0.0;
        Random random = new Random();
        horda = new Herd(MAX_STARLINGS);
        
        cantidadSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            cantidad = (int)cantidadSlider.getValue();
            // Realiza las acciones que desees con el nuevo valor del slider
        });
        leadershipSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            minLeadership = leadershipSlider.getValue();
            for (int i = 0; i < MAX_STARLINGS-1; i++) {
            boolean isLeader = starlings[i].setMinLeadership(minLeadership);
            if(!isLeader){
                horda.searchLeader((SocialFlyingAnimal)starlings[i]);
            }
        }
        });   
        
        
        gc = canvas.getGraphicsContext2D();
        for (int i = 0; i < MAX_STARLINGS-1; i++) {
            starlings[i] = new Starling(random);
            starlings[i].setId(i);
            starlings[i].InitRandomPosition(maxX, maxY);
            horda.setLeadership(starlings[i]);
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
        for (int i = 0; i < cantidad-1; i++) {
            starlings[i].NextPosition();
        }
    }
    GraphicsContext gc;
    private void draw() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < cantidad-1; i++) {
            gc.setFill(starlings[i].getColor());          
            gc.fillOval(starlings[i].getX() - 5, starlings[i].getY() - 5, starlings[i].getSize(),starlings[i].getSize());
        }
    }
    @FXML
    public void playPressed()
    {
        cantidad = (int)cantidadSlider.getValue();        
    }
}
