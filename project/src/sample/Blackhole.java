package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;

public class Blackhole extends ScreenObject{
    private ImageView imageView;

    public Blackhole(ScreenManager sm, int x, int y, int width, int height, Image image, Pane pane) {
        super(sm, x, y, width, height, image, pane);
        imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }
    public void start(){
        Random random=new Random();
        imageView.setX(random.nextDouble()*1000);
        imageView.setY(random.nextDouble()*500);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf=new KeyFrame(Duration.millis(10000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageView.setX(random.nextDouble()*1000);
                imageView.setY(random.nextDouble()*500);
                imageView.setFitWidth(width);
                imageView.setFitHeight(height);
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
