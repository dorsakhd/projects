package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Controller {
    @FXML
    Circle circle;
    @FXML
    AnchorPane pane;
    @FXML
    public void initialize() {
        circle.setFocusTraversable(true);
        circle.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
             switch (keyEvent.getCode())
             {
                 case F:
                     Circle circle2=new Circle(490,177,10,Color.BLACK);
                     pane.getChildren().add(circle2);
                 Timeline timeline = new Timeline();
                 timeline.setCycleCount(Timeline.INDEFINITE);
                 KeyFrame kf = new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>() {
                     @Override
                     public void handle(ActionEvent actionEvent) {
                         circle2.getTranslateX();
                         circle2.setTranslateX(circle2.getTranslateX()-90);
                     }
                 });
                     timeline.getKeyFrames().add(kf);
                     timeline.play();
                     break;
                 case SPACE:
                     Timeline timeline2 = new Timeline();
                     timeline2.setCycleCount(1);
                     double a=circle.getCenterY();
                     KeyFrame kf2 = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                         @Override
                         public void handle(ActionEvent actionEvent) {
                             circle.setTranslateY(circle.getCenterY()-100);

                         }
                     });
                     circle.setTranslateY(a);
                     timeline2.getKeyFrames().add(kf2);
                     timeline2.play();
                     break;
             }

             }
        });
    }
}

