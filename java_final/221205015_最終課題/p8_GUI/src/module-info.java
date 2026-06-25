module Task8_GUI {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	
	opens jp.ac.meijo_u.id221205015 to javafx.graphics, javafx.fxml;
}
