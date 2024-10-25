module com.example.regex_form {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.regex_form to javafx.fxml;
    exports com.example.regex_form;
}