package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Mario extends MovingScreenObject {
    private int speed;
    private boolean direction;
    private int dx = 1;
    private int rotate = 0;
    private ImageView imageView;
    private Bullet bullet;
    private AnchorPane mainPane;
    public Mario(ScreenManager sm,int x, int y, int width, int height, Image image, Pane pane,boolean direction) {
        super(sm,x, y, width, height, image,pane );
        this.direction=direction;
        imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                imageView.requestFocus();
            }
        });
    }


    @Override
    public String toString() {
        return "Mario{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", image=" + image +
                ", speed=" + speed +
                ", direction=" + direction +
                ", dx=" + dx +
                ", rotate=" + rotate +
                '}';
    }

    @Override
    public void startToMove() {
        imageView.setFocusTraversable(true);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        imageView.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case A:
                        imageView.setTranslateX(imageView.getTranslateX() - 5);

                        break;
                    case D:
                        imageView.setTranslateX(imageView.getTranslateX() + 5);
                        break;
                    case X:
                        imageView.setTranslateY(imageView.getTranslateY() + 50);
                        break;
                    case W:
                        imageView.setTranslateY(imageView.getTranslateY() - 50);
                        break;
                    case SPACE:
                        Timeline timeline = new Timeline();
                        timeline.setCycleCount(1);
                        timeline.setAutoReverse(true);
                        KeyFrame kf = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                imageView.setTranslateY(imageView.getTranslateY() - 100);
                                Timeline timeline = new Timeline();
                                timeline.setCycleCount(1);
                                timeline.setAutoReverse(true);
                                KeyFrame kf = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        imageView.setTranslateY(imageView.getTranslateY() + 100);
                                    }
                                });
                                timeline.getKeyFrames().add(kf);
                                timeline.play();
                            }
                        });
                        timeline.getKeyFrames().add(kf);
                        timeline.play();
                        break;
                    case F:
                        bullet=new Bullet(sm, (int) imageView.getTranslateX()+750, (int) imageView.getTranslateY()+150,width/6,height/5,pane,true);
                        bullet.startToMove();
                        bullet.addToPane();
                        break;
                }
            }
        });
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