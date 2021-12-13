package sample;

import javafx.scene.Node;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;

public class TurtleGenerator {
    private ScreenManager sm;
    private Image[]images;
    private Point[]pointsStart={new Point(0,700),new Point(0,580),new Point(500,430),new Point(500,270)};
    private Point[]pointsEnd={new Point(1000,0),new Point(1000,100),new Point(600,200),new Point(600,100)};
    private int width;
    private int height;
    public TurtleGenerator(ScreenManager sm) {
        this.sm=sm;
        images = new Image[1];
        images[0] = new Image("images/turtle.gif");
    }

    public void start(){
        for (int i = 0; i <4 ; i++) {
            int randomPI=(int)(Math.random()*4);
            Point randomPS=pointsStart[randomPI];
            Point randomPE=pointsEnd[randomPI];
            Image image=images[(int)(Math.random())];
            boolean direction;
            int speed=(int)(Math.random()*5)+1;
            Turtle turtle=new Turtle(sm,(int)((randomPE.x-randomPS.x)*Math.random()+randomPS.x),randomPS.y,55,100,images[0],sm.getPane(),speed,true,randomPS.x,randomPE.x);
            sm.addScreenObject(turtle);
            turtle.startToMove();
        }
    }

    public Image[] getImages() {
        return images;
    }
}
