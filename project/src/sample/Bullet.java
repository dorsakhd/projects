package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Bullet extends MovingScreenObject {
    private boolean direction;
    private Circle circle;
    private int dx=1;
    public Bullet(ScreenManager sm, int x, int y, int width, int height, Pane pane, boolean direction) {
        super(sm,x, y, width, height, pane);
        this.direction=direction;
         this.circle=new Circle(x,y,width/2,Color.PURPLE);
    }
    @Override
    public void startToMove() {
        sm.addScreenObject(this);
        dx = direction ? 1 : -1;
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (circle.getCenterX()>=pane.getWidth() && direction) {
                   removeFromPane();
                }
                if (circle.getCenterX()<0 && !direction) {
                   removeFromPane();
                }else {
                    circle.setCenterX(circle.getCenterX()+dx);
                }
            }
        });
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }


    @Override
    public void addToPane() {
        pane.getChildren().add(circle);
    }

    @Override
    public void removeFromPane() {
        pane.getChildren().remove(circle);
    }

    @Override
    public boolean intersects(Node node) {
        return circle.intersects(node.getBoundsInLocal());
    }

    @Override
    public ImageView getImageView() {
        return null;
    }


    public Circle getCircle() {
        return circle;
    }
}
