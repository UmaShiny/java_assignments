package jp.ac.meijo_u.id221205015;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Task8_GUI.fxml"));
			Scene scene = new Scene(root,672,336);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println("System here");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		System.out.println("after launch");
	}
}
