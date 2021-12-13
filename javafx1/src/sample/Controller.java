package sample;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Controller {
  @FXML
    TextField nameTF;
  @FXML
    ColorPicker insidecolor;
  @FXML
    ColorPicker outsidecolor;
  @FXML
    Slider lenght;
  @FXML
    Slider widht;
  @FXML
    Slider x;
  @FXML
    Slider y;
  @FXML
    Button ok;
  @FXML
    Button drawBT;
  @FXML
    AnchorPane anchorpane2;

    @FXML
    public void initialize() {
        ok.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Rectangle rectangle=new Rectangle(x.getValue(),y.getValue());
                rectangle.setName(nameTF.getText());
                rectangle.setInsidecolor(insidecolor.getValue());
                rectangle.setOoutsideclor(outsidecolor.getValue());
                rectangle.setLength(lenght.getValue());
                rectangle.setWidth(widht.getValue());
                System.out.println(rectangle.toString());
            }
        });
        drawBT.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                javafx.scene.shape.Rectangle rectangle2=new javafx.scene.shape.Rectangle(x.getValue(),y.getValue(),widht.getValue(),lenght.getValue());
                rectangle2.setFill(insidecolor.getValue());
                rectangle2.setStroke(outsidecolor.getValue());
                anchorpane2.getChildren().add(rectangle2);
            }
        });
    }


}
