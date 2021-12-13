package sample;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Controller {
    @FXML
    AnchorPane manepane;
    @FXML
    public void initialize() {
        int x = (int) (Math.random()*700.0);
        for (int i = 0; i < 40;i++) {
            int shapeType = (int) (Math.random()*2.0);
           // System.out.println(shapeType);
            if (shapeType==0) {
                Rectangle rectangle=new Rectangle((int) ((Math.random() * 700.0)),(int) ((Math.random() * 800.0)),(int) ((Math.random() * 500.0)),(int) ((Math.random() * 500.0)));
                rectangle.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                manepane.getChildren().add(rectangle);
                rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        manepane.getChildren().remove(rectangle);
                    }
                });
                TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000));
                translateTransition.setFromX(Math.random()*600);
                translateTransition.setToX(Math.random()*600);
                translateTransition.setCycleCount(2);
                translateTransition.setAutoReverse(true);
                RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000));
                rotateTransition.setByAngle(180f);
                rotateTransition.setCycleCount(4);
                rotateTransition.setAutoReverse(true);
                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000));
                scaleTransition.setToX(2f);
                scaleTransition.setToY(2f);
                scaleTransition.setCycleCount(2);
                scaleTransition.setAutoReverse(true);
                ParallelTransition prallelTransition  = new ParallelTransition(rectangle,translateTransition,rotateTransition,scaleTransition);
                prallelTransition.setCycleCount(Timeline.INDEFINITE);
                prallelTransition.play();
            } else if(shapeType==1) {

                Circle circle = new Circle((int) ((Math.random() * 600.0)), (int) ((Math.random() * 800.0)), ((Math.random() * 100.0) + 3));
                circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                circle.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                manepane.getChildren().add(circle);
                circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        manepane.getChildren().remove(circle);
                    }
                });
                TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000));
                translateTransition.setFromX(Math.random()*600);
                translateTransition.setToX(Math.random()*600);
                translateTransition.setCycleCount(2);
                translateTransition.setAutoReverse(true);
                RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000));
                rotateTransition.setByAngle(180f);
                rotateTransition.setCycleCount(4);
                rotateTransition.setAutoReverse(true);
                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000));
                scaleTransition.setToX(2f);
                scaleTransition.setToY(2f);
                scaleTransition.setCycleCount(2);
                scaleTransition.setAutoReverse(true);
                ParallelTransition prallelTransition  = new ParallelTransition(circle,translateTransition,rotateTransition,scaleTransition);
                prallelTransition.setCycleCount(Timeline.INDEFINITE);
                prallelTransition.play();
            }
        }
    }
}
