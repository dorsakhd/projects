package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.*;
import java.util.Random;

public class Controller {
    @FXML
    AnchorPane mainPane;
    @FXML
    public void initialize() {
        ScreenManager screenManager = new ScreenManager(mainPane);
        screenManager.start();
    }
}


