package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Login extends Application {
	private Scene scene;

	public static void main(String[] args) {
		Application.launch(Login.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

		stage.setTitle("Library Management System");

		scene = new Scene(root, 640, 480);

		// Add CSS Style Sheet (located in same package as this class).
		String css = this.getClass().getResource("Style.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.setResizable(false);

		stage.show();

	}

}
