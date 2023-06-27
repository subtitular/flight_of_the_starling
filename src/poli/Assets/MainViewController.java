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

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private static final int RADIUS = 100;
    private static final double ANGLE_INCREMENT = 0.05;

    
    private double centerX;
    private double centerY;
    private double angle;
    private GraphicsContext gc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

/*        primaryStage.setTitle("Circle Animation");
        primaryStage.setScene(scene);
        primaryStage.show();*/

        centerX = WIDTH / 2.0;
        centerY = HEIGHT / 2.0;
        angle = 0.0;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
        update();
        draw();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    private void update() {
        angle += ANGLE_INCREMENT;
        if (angle > 2 * Math.PI) {
          angle -= 2 * Math.PI;
        }
    }
    
    private void draw() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        double x = centerX + RADIUS * Math.cos(angle);
        double y = centerY + RADIUS * Math.sin(angle);

        gc.setFill(Color.RED);
        gc.fillOval(x - 5, y - 5, 10, 10);
    }

    
}
