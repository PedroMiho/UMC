module aa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens application to javafx.graphics, javafx.fxml;
    opens Controller to javafx.fxml; // <-- adicione essa linha

    exports Controller; // <-- adicione essa linha também
}
