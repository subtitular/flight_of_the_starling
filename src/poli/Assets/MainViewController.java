/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poli.Assets;

import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author subti
 */
public class MainViewController implements Initializable {

    @FXML
    private Canvas canvas;

    private double centerX;
    private double centerY;
    private double angle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        /*centerX = canvas.getWidth() / 2.0;
        centerY = canvas.getHeight() / 2.0;
        angle = 0.0;

        // Crear la animación para actualizar el punto en cada fotograma
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            update();
            draw();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();*/
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