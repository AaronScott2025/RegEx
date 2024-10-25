package com.example.regex_form;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {

    @FXML
    private Label lblDate;
    @FXML
    private Button submit;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirst;

    @FXML
    private Label lblLast;

    @FXML
    private Label lblZip;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirst;

    @FXML
    private TextField txtLast;

    @FXML
    private TextField txtZip;

    @FXML
    /**
     * @param checkDate() True/false for the format of the date
     * @param checkName() True/false for the format of the name
     * @param checkEmail() True/false for the format of the Email
     * @param checkZip() True/false for the format of the zip
     * @returns New screen
     * @Throws IO Exception if New Screen fails.
     *
     */
    void launchScreen(ActionEvent event) throws IOException {
        Stage primaryStage = HelloApplication.getPrimaryStage();
        boolean pass = true;
        if(!checkDate()) {
            pass = false;
            lblDate.setVisible(true);
        } else {
            lblDate.setVisible(false);
        }
        if(!checkName()) {
            pass = false;
            lblFirst.setVisible(true);
            lblLast.setVisible(true);
        } else {
            lblFirst.setVisible(true);
            lblLast.setVisible(true);
        }
        if(!checkEmail()) {
            pass = false;
            lblEmail.setVisible(true);
        } else {
            lblEmail.setVisible(false);
        }
        if(!checkZip()) {
            pass = false;
            lblZip.setVisible(true);
        } else {
            lblZip.setVisible(false);
        }
        if(pass) {
            Parent root = FXMLLoader.load(getClass().getResource("newview.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hello!");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    }
    private boolean checkName(){
        final String regex = "[a-zA-z]{2,25}";
        final String string = txtFirst.getText();
        final String string2 = txtLast.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher1 = pattern.matcher(string);
        final Matcher matcher2 = pattern.matcher(string2);
        if(matcher1.matches() && matcher2.matches()) {
            return true;
        }
        return false;
    }
    private boolean checkDate() {
        final String regex = "(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\\d{4})";
        final String string = txtDOB.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        if(matcher.matches()) {
            return true;
        }
        return false;
    }
    private boolean checkEmail() {
        final String regex = "(\\w+)(@)(farmingdale.edu)";
        final String string = txtEmail.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        if(matcher.matches()) {
            return true;
        }
        return false;
    }
    private boolean checkZip() {
        final String regex = "[0-9]{5}";
        final String string = txtZip.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    public String getDate() {
        return txtDOB.getText();
    }
    public String getEmail() {
        return txtEmail.getText();
    }
    public String getFirst() {
        return txtFirst.getText();
    }
    public String getLast() {
        return txtLast.getText();
    }
    public String getZip() {
        return txtZip.getText();
    }

    public Button getSubmit() {
        return submit;
    }
}
