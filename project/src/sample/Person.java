package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.Serializable;

public  class Person implements Serializable {
    protected String usernameField;
    protected String creatpasswordField;
    protected String username2Field;
    protected String passwordField;

    public Person(String username2Field, String passwordField) {
        this.username2Field = username2Field;
        this.passwordField = passwordField;
    }

    public String getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(String usernameField) {
        this.usernameField = usernameField;
    }

    public String getCreatpasswordField() {
        return creatpasswordField;
    }

    public void setCreatpasswordField(String creatpasswordField) {
        this.creatpasswordField = creatpasswordField;
    }

    public Person(TextField firstnameField, TextField lastnameField, TextField usernameField, PasswordField creatpasswordField, TextField emailField) {
    }
}
