module com.example.firstjavafxproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires java.json;

    opens com.example.firstjavafxproject to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.example.firstjavafxproject;
}
