package com.example.regex_form;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    private static Stage primaryStage;
    private HelloController controller;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
        controller = fxmlLoader.getController();
        scene.setOnKeyPressed(event -> handleKeyPress(event));
    }

    public static void main(String[] args) {
        launch();
    }
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    private void handleKeyPress(KeyEvent event) {
        String txtDOB = controller.getDate();
        String txtLast = controller.getLast();
        String txtFirst = controller.getFirst();
        String txtEmail = controller.getEmail();
        String txtZip = controller.getZip();
        Button submit = controller.getSubmit();
        if(!Objects.equals(txtLast, "") && !Objects.equals(txtFirst, "") && !Objects.equals(txtDOB, "") && !Objects.equals(txtEmail, "") && !Objects.equals(txtZip, "")) {
            submit.setDisable(false);
        } else {
            submit.setDisable(true);
        }
    }
}