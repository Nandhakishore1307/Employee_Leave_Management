module Employee_Leave_Management_System {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	requires java.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
