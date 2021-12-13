package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Time extends ScreenObject {
    private Text text;
    private int x2;
    private int y2;
    private int hour;
    private int minute;
    private int second;
    private ImageView imageView;
    public Time(ScreenManager sm, int x, int y, int width, int height, Image image, Pane pane,Text text,int x2,int y2,int hour,int minute,int second) {
        super(sm, x, y, width, height, image, pane);
        this.x2=x2;
        this.y2=y2;
        this.hour=hour;
        this.minute=minute;
        this.second=second;
        imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        this.text = new Text();
        this.text.setX(x2);
        this.text.setY(y2);
        this.text.getText();
        this.text.setFill(Color.BLACK);
        this.text.setScaleY(2);
        this.text.setScaleX(2);
        this.text.setX(x2);
        this.text.setY(y2);
        this.text.setScaleY(2);
        this.text.setScaleX(2);
        this.text.setFont(Font.font ("Arial", 11));
        this.text.setFill(Color.BLUE);
    }

    public void start(Pane pane){
        Timeline timeline = new Timeline();
        KeyFrame kf = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                second--;
                if (second == 0) {
                    second = 60;
                    minute--;
                    if (minute == 0) {
                        minute = 60;
                        hour--;
                    }
                }
              text.setText(hour+ ":"+minute+":"+second);
            }
        });
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(kf);
        timeline.play();

    }

    @Override
    public void addToPane() {
        pane.getChildren().add(imageView);
        pane.getChildren().add(text);

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
