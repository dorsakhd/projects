package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.*;

public class Controller {
    private static Object Person;
    @FXML
    Tab tabpane1;
    @FXML
    Label firstname;
 @FXML
    Label lastname;
 @FXML
    Label age;
 @FXML
    TextField first;
 @FXML
    TextField last;
 @FXML
    Slider age1;
 @FXML
    Button register;
 @FXML
    Pane anchorpane;
 @FXML
 Label id;
 @FXML
 Label password;
 @FXML
 TextField idtfield;
 @FXML
 TextField passwordbox;
 @FXML
  Tab tabpane2;
 @FXML
 Label id2;
 @FXML
 Label password2;
 @FXML
 TextField idfield;
 @FXML
 TextField passwordfield;
 @FXML
 Button enterbtn;
 @FXML
 Tab tabpane3;
 @FXML
 Label fromx;
 @FXML
 Label fromy;
 @FXML
 Label tox;
 @FXML
 Label toy;
 @FXML
 Label lenght;
 @FXML
 Label widht;
 @FXML
 Label insidecolor;
 @FXML
 Label outsidecolor;
 @FXML
 Slider fromxslider;
 @FXML
 Slider fromyslider;
 @FXML
 Slider toxslider;
 @FXML
 Slider toyslider;
 @FXML
 Slider lenghtslider;
 @FXML
 Slider widhtslider;
 @FXML
 ColorPicker insidecolorpicker;
 @FXML
 ColorPicker outsidecolorpicker;
 @FXML
 Button drawbtn;
 @FXML
 TabPane tabpane;
 @FXML
 AnchorPane anchorpane3;
 @FXML
    public void initialize(){
     anchorpane.getStylesheets().add("form.css");
     register.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent mouseEvent) {
           first.getText();
           last.getText();
           age1.getValue();
           id.getText();
           password.getText();
           Person person=new Person(first,last,age1,id,password);
             try {
                 FileOutputStream file = new FileOutputStream(new File("users.txt"));
                 ObjectOutputStream object = new ObjectOutputStream(file);
                 object.writeObject(Person);
                 object.close();
                 file.close();
                 System.out.println("file save successfully");
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }finally {

             }
         }
         public  void load(Person person){
             try {
                 FileInputStream fileInputStream=new FileInputStream("users.txt");
                 ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
                 Person=(Person)objectInputStream.readObject();
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             } catch (ClassNotFoundException e) {
                 e.printStackTrace();
             }
         }
     });
     enterbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent mouseEvent) {
             Person[]person=new Person[10];

         }
     });
     drawbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent mouseEvent) {
             Rectangle rectangle=new Rectangle(fromxslider.getValue(),fromyslider.getValue(),widhtslider.getValue(),lenghtslider.getValue());
             rectangle.setFill(insidecolorpicker.getValue());
             rectangle.setStroke(outsidecolorpicker.getValue());
             anchorpane3.getChildren().add(rectangle);
             TranslateTransition translateTransition=new TranslateTransition(Duration.millis(1000),rectangle);
             translateTransition.setFromX(fromxslider.getValue());
             translateTransition.setFromY(fromyslider.getValue());
             translateTransition.setToX(toxslider.getValue());
             translateTransition.setToY(toyslider.getValue());
             translateTransition.setCycleCount(Animation.INDEFINITE);
             translateTransition.setAutoReverse(true);
             translateTransition.play();
     }
     });
 }
}
