/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package poli.Views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
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
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import poli.Models.Herd;
import poli.Models.Point;
/**
 *
 * @author subti
 */
public class MainView extends Application implements Initializable {
    //@FXML
    //private Canvas canvas;
    @FXML
    private Slider cantidadSlider;
    @FXML
    private Button playButton;
    
    private static final double MAX_ATTRACT_DISTANCE = 350;
    private static final double MIN_ATTRACT_DISTANCE = 0.1;
    private static final double FORCE_CONSTANT = 5000;

    private double mouseX;
    private double mouseY;

    private GraphicsContext g;

    private List<Particle> particles = new ArrayList<>();
    @FXML
    private Pane pane;

    @Override
    public void start(Stage stage) throws Exception {
        var scene = new Scene(createContent());
        //Scene scene = (Scene)FXMLLoader.load(getClass().getResource("MainView.fxml"));
        //pane = (Pane)createContent();
        scene.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY = e.getY();
        });

        stage.setScene(scene);
        stage.show();
    }
    private Parent createContent() {
        for (int y = 0; y < 720 / 10; y++) {
            for (int x = 0; x < 1280 / 10; x++) {
                particles.add(new Particle(x * 10, y * 10, Color.BLUE));
            }
        }

        var canvas = new Canvas(1280, 720);
        g = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

        pane = new Pane(canvas);
        pane.setPrefSize(1280, 720);
        return pane;
    }
        private void onUpdate() {
        g.clearRect(0, 0, 1280, 720);

        var cursorPos = new Point2D(mouseX, mouseY);

        particles.forEach(p -> {
            p.update(cursorPos);

            g.setFill(p.color);

            g.fillOval(p.x - 1, p.y - 1, 2, 2);
        });
    }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
 

    @FXML
    public void playPressed()
    {

    }
    
    private static class Particle {
        double x;
        double y;
        Color color;

        double originalX;
        double originalY;

        Particle(double x, double y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;

            originalX = x;
            originalY = y;
        }

        void update(Point2D cursorPos) {
            var distance = cursorPos.distance(x, y);

            if (distance > MAX_ATTRACT_DISTANCE) {
                x = originalX;
                y = originalY;
            } else if (distance < MIN_ATTRACT_DISTANCE) {
                x = cursorPos.getX();
                y = cursorPos.getY();
            } else {
                var vector = cursorPos.subtract(x, y);
                var scaledLength = FORCE_CONSTANT * 1 / distance;
                vector = vector.normalize().multiply(scaledLength);

                x = originalX + vector.getX();
                y = originalY + vector.getY();

                // C * 1 / d

                // * ----> x
                // * -->   x
            }
        }
    }
}
