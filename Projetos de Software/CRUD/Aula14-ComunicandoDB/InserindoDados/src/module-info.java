module aa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens application to javafx.graphics, javafx.fxml;
    opens Controller to javafx.fxml;

    exports Controller;
}
