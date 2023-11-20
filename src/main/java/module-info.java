module com.example.logreg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.logreg to javafx.fxml;
    exports com.example.logreg;
}