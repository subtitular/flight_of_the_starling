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
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
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
    private List<Point> points = new ArrayList<>();
    private AnimationTimer animationTimer;
    
    private final ArrayList<Circle> circles = new ArrayList<>();
    private final ArrayList<Line>lines = new ArrayList<>();
    private int counter = 0,  total = 100;
    private int factor = 2; //factor 1 does not draw lines
    private int deletedLinesCounter = 0; //j is not a good choice of name
    private AnimationTimer draw, deleteLines; //why static ?

    
    
private Herd horda;
    @Override
    public void start(Stage primaryStage) throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/
        //System.out.println(getClass());
        Group g = new Group();
        //Scene s = new Scene(g, 600, 600);
        
        
        BorderPane root = new BorderPane();

        //Scene scene = new Scene(root, 800, 600);
        Scene scene = (Scene)FXMLLoader.load(getClass().getResource("MainView.fxml"));
        scene.setFill(Color.BLACK);
        
        primaryStage.setMaximized(true);
        //primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("El Vuelo de los Estorninos");
        
        //scene = (Scene)FXMLLoader.load(getClass().getResource("MainView.fxml"));
        //root. = root.load();
        
        //Scene scene = new Scene(root, 800, 600);

        // Configurar el escenario principal (Stage)

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
        drawCircle(g);

        draw = new AnimationTimer(){
            @Override
            public void handle(long now) {

                if(counter == total){
                    deleteLines.start();
                    stop(); //stop draw until it restarts by deleteLines
                } else {
                    drawLine(g);    // drawLines(g);
                    counter++;
                }
            }
        };

        deleteLines = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (deletedLinesCounter < lines.size()){
                    //draw.stop();  // no need to stop over again. stop in draw
                    g.getChildren().removeIf(node -> node == lines.get(deletedLinesCounter));
                    deletedLinesCounter++;
                } else {
                    //prepare next draw
                    total++;
                    counter = 0;
                    factor++;
                    deletedLinesCounter = 0;
                    lines.clear();
                    g.getChildren().removeAll(circles);
                    circles.clear();
                    drawCircle(g);
                    stop();
                    draw.start();
                }
            }
        };

        draw.start();
    }
    
        private void drawCircle(Group g) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int i = 0; i < total; i++) {
            Circle dot = new Circle(Math.cos(2*Math.PI/ total * i + Math.PI / 2)* 300 + 300,
                    Math.sin(2*Math.PI/ total * i + Math.PI / 2 )* 300 + 300, 5);
            dot.setFill(Color.PURPLE);
            gc.setFill(Color.ALICEBLUE);
            gc.fillOval(dot.getCenterX(),dot.getCenterY(),20,20);
            circles.add(dot);
        }
        g.getChildren().addAll(circles);
    }
        
    private void drawLine(Group g) {

        Line l = new Line(circles.get(counter % total).getCenterX(),
                circles.get(counter % total).getCenterY(),
                circles.get(counter * factor % total).getCenterX(),
                circles.get(counter * factor % total).getCenterY());
        l.setStroke(Color.PURPLE);
        g.getChildren().add(l);
        lines.add(l);
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
        GraphicsContext gc = canvas.getGraphicsContext2D();
        points = horda.getPoints();
        //startAnimation();
        /*new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Limpiar el canvas
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                
                // Dibujar cada punto en el canvas
                for (Point point : points) {
                    drawPoint(gc, point);
                }

                // Realizar modificaciones en los puntos (puedes moverlos, cambiar sus coordenadas, etc.)
                updatePoints();
            }
        }.start();*/
        
        // Crear la animación para actualizar el punto en cada fotograma
        /*Timeline timeline = new Timeline(new KeyFrame(Duration.millis(160), event -> {
            update();
            draw();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();*/
    }
    private void drawPoint(GraphicsContext gc, Point point) {
        gc.setFill(Color.RED);
        gc.fillOval(point.getPositionX(), point.getPositionY(), 10, 10);
    }

    private void updatePoints() {
        // Realizar modificaciones en los puntos (por ejemplo, cambiar sus coordenadas)
    }

    private void update() {
        angle += 0.01;
        if (angle > 2 * Math.PI) {
            angle -= 2 * Math.PI;
        }
    }

    /*private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2.0 - 5;
        double x = centerX + radius * Math.cos(angle);
        double y = centerY + radius * Math.sin(angle);
        
        
        gc.setFill(Color.GRAY);
        gc.fillOval(x - 5, y - 5, 10, 10);
        points = horda.getPoints();
        for(Point point:points){
            gc.fillOval(point.getPositionX() - 5, point.getPositionY() - 5, 10, 10);
        }
    }*/
    private void startAnimation() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        animationTimer = new AnimationTimer() {
            private long lastUpdate = 0;
            private final int animationInterval = 1000_000_000; // Intervalo de tiempo en nanosegundos (en este caso, 0.1 segundos)

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= animationInterval) {
                    // Limpia el canvas
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                    // Dibuja cada punto en el canvas
                    for (Point point : points) {
                        drawPoint(gc, point);
                    }

                    // Realiza modificaciones en los puntos (puedes moverlos, cambiar sus coordenadas, etc.)
                    updatePoints();

                    lastUpdate = now;
                }
            }
        };

        animationTimer.start();
    }

    public void playPressed()
    {
        /*
        cantidad = (int)cantidadSlider.getValue();
	horda = new Herd();
	horda.Create(cantidad, canvas.getWidth(),canvas.getHeight());
        */
    }
}
