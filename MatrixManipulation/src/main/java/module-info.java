module com.example.matrixmanipulation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.matrixmanipulation to javafx.fxml;
    exports com.example.matrixmanipulation;
}