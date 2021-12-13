package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Score extends ScreenObject {
    private Text text;
    private int x2;
    private int y2;
    private ImageView imageView;
    static int score=0;
    public Score(ScreenManager sm, int x, int y, int width, int height, Image image, Pane pane,Text text,int x2,int y2) {
        super(sm, x, y, width, height, image, pane);
        this.x2=x2;
        this.y2=y2;
        imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        this.text = new Text();
        this.text.setX(x2);
        this.text.setY(y2);
        this.text.setText(String.valueOf(score));
        this.text.getText();
        this.text.setFill(Color.BLACK);
        this.text.setScaleY(3);
        this.text.setScaleX(3);
    }
    public static void addScore(int a){
        score=score+a;
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
