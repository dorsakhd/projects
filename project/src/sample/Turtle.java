package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Turtle extends MovingScreenObject {
    private int speed;
    private boolean direction;
    private int dx = 1;
    private int rotate = 0;
    private double start;
    private double end;
    private ImageView imageView;

    public Turtle(ScreenManager sm, int x, int y, int width, int height, Image image, Pane pane, int speed, boolean direction, int start, int end) {
        super(sm,x, y, width, height, image, pane);
        this.speed=speed;
        this.direction=direction;
        this.start=start;
        this.end=end;
        this.imageView = new ImageView(image);
        this.imageView.setX(x);
        this.imageView.setY(y);
        this.imageView.setFitWidth(width);
        this.imageView.setFitHeight(height);
    }

    public void addToPaneAndMove(Pane pane) {
    }

    @Override
    public void startToMove() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame(Duration.millis(speed * 20), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (imageView.getX()>=end && direction) {
                    dx = -dx;
                    rotate = 180;
                    imageView.setRotationAxis(Rotate.Y_AXIS);
                    imageView.setRotate(rotate);
                    direction=false;
                }
                if (imageView.getX() <=start && !direction) {
                    dx = -dx;
                    rotate = 0;
                    imageView.setRotationAxis(Rotate.Y_AXIS);
                    imageView.setRotate(rotate);
                    direction=true;
                }
                imageView.setX(imageView.getX() + dx);
            }

        });
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }



    @Override
    public void addToPane() {
        pane.getChildren().add(imageView);
    }

    @Override
    public void removeFromPane() {
        pane.getChildren().remove(imageView);
    }

    @Override
    public boolean intersects(Node node) {
        return imageView.intersects(node.getBoundsInLocal());
    }
    @Override
    public ImageView getImageView() {
        return imageView;
    }
}

