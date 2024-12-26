module PRAKTIKUM7 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.fxml;
	opens model to javafx.base;
}
