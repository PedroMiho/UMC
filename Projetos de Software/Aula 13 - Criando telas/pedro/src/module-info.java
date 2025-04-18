module pedro {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires java.sql;

    opens application to javafx.fxml;
    opens com.somar.controller to javafx.fxml;

    exports application;
    exports com.somar.controller;
}
