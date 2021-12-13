package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class MovingScreenObject extends ScreenObject {
    public MovingScreenObject(ScreenManager sm,int x, int y, int width, int height, Image image, Pane pane) {
        super(sm,x, y, width, height, image, pane);
    }

    public MovingScreenObject(ScreenManager sm,int x, int y, int width, int height, Pane pane) {
        super(sm,x, y, width, height, pane);
    }

    @Override
    public ImageView getImageView() {
        return null;
    }


    public abstract void startToMove();

}
