package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Ajor extends ScreenObject {
   private ImageView imageView;

    public Ajor(ScreenManager sm, int x, int y, int width, int height, Image image, Pane pane) {
        super(sm, x, y, width, height, image, pane);
        imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void addToPane() {
     pane.getChildren().add(imageView);
    }

    @Override
    public void removeFromPane() {
        pane.getChildren().add(imageView);
    }

    @Override
    public boolean intersects(Node node) {
        return  imageView.intersects(node.getBoundsInLocal());
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }

}
