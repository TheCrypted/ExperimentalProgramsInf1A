module com.example.gamedevv1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.gamedevv1 to javafx.fxml;
    exports com.example.gamedevv1;
}