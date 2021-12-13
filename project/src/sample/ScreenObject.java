package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class ScreenObject extends ArrayList<Bullet> {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    protected Pane pane;
    protected ScreenManager sm;
    public ScreenObject(ScreenManager sm,int x, int y, int width, int height, Image image, Pane pane) {
        this.sm=sm;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.pane=pane;
    }

    public ScreenObject(ScreenManager sm,int x, int y, int width, int height,Pane pane) {
        this.sm=sm;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.pane=pane;
    }

    public abstract void addToPane();
    public abstract void removeFromPane();
    public abstract boolean intersects(Node node);
    public abstract ImageView getImageView();
}
