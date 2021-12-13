package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class Login {
    @FXML
    AnchorPane anchorPane;
    @FXML
    TabPane tabPane;
    @FXML
    Tab signupTab;
    @FXML
    Tab loginTab;
    @FXML
    Label firstnameLable;
    @FXML
    Label lastnameLable;
    @FXML
    Label usernameLable;
    @FXML
    Label creatpasswordLable;
    @FXML
    Label emailLable;
    @FXML
    TextField firstnameField;
    @FXML
    TextField lastnameField;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField creatpasswordField;
    @FXML
    TextField emailField;
    @FXML
    Button registerButton;
    @FXML
    Label username2Lable;
    @FXML
    Label passwordLable;
    @FXML
    TextField username2Field;
    @FXML
    PasswordField passwordField;
    @FXML
    Button loginButton;
    @FXML
    private Person[] people = new Person[10];
    public void initialize(){
        registerButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                firstnameField.getText();
                lastnameField.getText();
                usernameField.getText();
                creatpasswordField.getText();
                emailField.getText();
                load();
                for (int i = 0; i < people.length; i++) {
                    people[i] = new Person(firstnameField, lastnameField, usernameField, creatpasswordField, emailField);
                    if (!usernameField.getText().equals(people[i].getUsernameField())) {
                        try {
                            FileOutputStream file = new FileOutputStream(new File("users.txt"));
                            ObjectOutputStream object = new ObjectOutputStream(file);
                            object.writeObject(people);
                            object.close();
                            file.close();
                            System.out.println("your account created");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();

                        } finally {
                            break;
                        }
                    }else {
                        System.out.println("Username is already exists and used, please type another one");
                    }
                }
                Parent root = null;
                Stage primaryStage=new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                primaryStage.setTitle("mario");
                primaryStage.setScene(new Scene(root, 600, 400));
                primaryStage.show();
            }

        });
        loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                load();
                username2Field.getText();
                passwordField.getText();
                for (int i = 0; i <people.length ; i++) {
                    if(people[i]!=null){

                    if(username2Field.getText().equals(people[i].getUsernameField()) && passwordField.getText().equals(people[i].getCreatpasswordField())){
                    }}

                }
                Parent root = null;
                Stage primaryStage=new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                primaryStage.setTitle("mario");
                primaryStage.setScene(new Scene(root, 600, 400));
                primaryStage.show();
            }
        });

    }
    public  void load(){
        try {
            FileInputStream fileInputStream=new FileInputStream("users.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            people=(Person[]) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }}


}
