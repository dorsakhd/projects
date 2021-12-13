package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.io.*;
import java.util.ArrayList;

public class ScreenManager {
    private ArrayList<ScreenObject>screenObjects=new ArrayList<>();
    private ArrayList<Turtle>turttles=new ArrayList<>();
    private ArrayList<Bullet>bullets=new ArrayList<>();
    private Mario mario;
    private Mario luigi;
    private Pane pane;
    private TurtleGenerator turtleGenerator;
    public ScreenManager(Pane pane){
        this.pane=pane;
    }
    public void start() {
        Background background=new Background(this,0,0,2000,1000,new Image("images/171-1717739_cute-light-pink-wallpapers-57-images-light-pink.jpg"),pane);
        addScreenObject(background);
        Score score=new Score(this,1400,20,150,80,new Image("images/luigiscore.png"),pane,new Text(),1495,65);
        addScreenObject(score);
        Score score2=new Score(this,50,20,150,80,new Image("images/marioscore.png"),pane,new Text(),150,65);
        addScreenObject(score2);
        Time time=new Time(this,740,20,150,80,new Image("images/time.png"),pane,new Text(),830,65,1,01,01);
        addScreenObject(time);
        time.start(pane);
        TurtleGenerator turtleGenerator=new TurtleGenerator(this);
        turtleGenerator.start();
        Blackhole blackhole=new Blackhole(this,680,270,100,80,new Image("images/blackhole .png"),pane);
        blackhole.start();
        addScreenObject(blackhole);
        Blackhole blackhole2=new Blackhole(this,1100,420,100,80,new Image("images/blackhole2.png"),pane);
        addScreenObject(blackhole2);
        blackhole2.start();
        Tunnel tunnel=new Tunnel(this,0,270,150,80,new Image("images/tunnel.png"),pane);
        addScreenObject(tunnel);
        Tunnel tunnel2=new Tunnel(this,1450,700,150,80,new Image("images/tunnel2.png"),pane);
        addScreenObject(tunnel2);
        Ajor ajors[]={new Ajor(this,0,780,800,100,new Image("images/brick1.png"),pane),
                new Ajor(this,800,780,800,100,new Image("images/brick1.png"),pane),
                new Ajor(this,700,200,200,50,new Image("images/brick1.png"),pane),
                new Ajor(this,0,350,750,50,new Image("images/brick1.png"),pane),
                new Ajor(this,850,350,750,50,new Image("images/brick1.png"),pane),
                new Ajor(this,400,500,800,50,new Image("images/brick1.png"),pane),
                new Ajor(this,0,500,300,50,new Image("images/brick1.png"),pane),
                new Ajor(this,1300,500,300,50,new Image("images/brick1.png"),pane),
                new Ajor(this,700,650,200,50,new Image("images/brick1.png"),pane),
                new Ajor(this,0,650,600,50,new Image("images/brick1.png"),pane),
                new Ajor(this,1000,650,600,50,new Image("images/brick1.png"),pane)};
        for (int i=0;i<11;i++)
        {
            addScreenObject(ajors[i]);
        }
        luigi=new Mario(this,750,560,120,100,new Image("images/luigi.png"),pane,true);
        addScreenObject(luigi);
        luigi.startToMove();
        mario=new Mario(this,730,100,170,110,new Image("images/mario.gif"),pane,true);
        addScreenObject(mario);
        startCheckConflict(mario);
        mario.startToMove();
        Button save=new Button("Save");
        pane.getChildren().add(save);
        save.setPrefWidth(100);
        save.setLayoutX(150);
        save.setLayoutY(20);
        save.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                load();
                try {
                    FileOutputStream file = new FileOutputStream(new File("save.txt"));
                    ObjectOutputStream object = new ObjectOutputStream(file);
                    object.writeObject(mario);
                    object.close();
                    file.close();
                    System.out.println("file save successfully");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            public  void load(){
                try {
                    FileInputStream fileInputStream=new FileInputStream("users.txt");
                    ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
                    mario=(Mario) objectInputStream.readObject();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }}
        });

    }
    public void addScreenObject(ScreenObject screenObject){
        screenObjects.add(screenObject);
        if(screenObject instanceof Turtle)
            turttles.add((Turtle)screenObject);
        if(screenObject instanceof Bullet)
            bullets.add((Bullet) screenObject);
           screenObject.addToPane();
        startCheckConflict(screenObject);
    }
    public void removeScreenObject(ScreenObject screenObject){
        screenObjects.remove(screenObject);
        if(screenObject instanceof Turtle)
            turttles.remove((Turtle)screenObject);
        if(screenObject instanceof Bullet)
            bullets.remove((Bullet) screenObject);
        screenObject.removeFromPane();
        startCheckConflict(screenObject);
    }
    public void startCheckConflict(ScreenObject screenObject){
        if(screenObject instanceof Bullet){
            Bullet bullet=(Bullet)screenObject;
            bullet.getCircle().centerXProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    boolean isConfilcted=false;
                    Turtle conflictedTurtle=null;
                    for (int i = 0; i <turttles.size(); i++) {
                        if (turttles.get(i).intersects(bullet.getCircle())) {
                            isConfilcted = true;
                            conflictedTurtle = turttles.get(i);
                        }
                    }
                            if (isConfilcted){
                                removeScreenObject(conflictedTurtle);
                                removeScreenObject(bullet);
                                Score.addScore(10);
                            }
                }
            });
        }
        else if (screenObject.getImageView()!=null){
            screenObject.getImageView().xProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    if (screenObject instanceof Turtle) {
                        Turtle turtle =(Turtle)screenObject;
                        if(turtle.intersects(mario.getImageView())){
                            removeScreenObject(mario);
                        }
                        if(turtle.intersects(luigi.getImageView())){
                            removeScreenObject(luigi);
                        }
                    }
                }
            });

   }

    }
    public Pane getPane(){
        return pane;
    }


}
