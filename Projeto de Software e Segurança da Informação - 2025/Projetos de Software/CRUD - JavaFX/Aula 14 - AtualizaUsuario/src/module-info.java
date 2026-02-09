module CriandoTelas {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
    exports controller;
    opens controller to javafx.fxml;

    exports application; 
    opens application to javafx.graphics;
}
