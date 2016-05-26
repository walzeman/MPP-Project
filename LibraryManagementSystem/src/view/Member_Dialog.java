package view;


import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Member_Dialog extends Stage {
	Stage primaryStage;
	
	GridPane grid = new GridPane();
	
	public Member_Dialog(Stage ps){
		
		//setTitle("Warning!");
		Text text = new Text(" Data is added");
		text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
	
		StackPane root = new StackPane();
		root.getChildren().add(text);
		Scene scene = new Scene(root, 220, 150);
		setScene(scene);
	//	primaryStage.show();
		
		
	}
}
