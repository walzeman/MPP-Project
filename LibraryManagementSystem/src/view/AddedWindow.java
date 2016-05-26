package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddedWindow extends Stage {
	
	Stage primary;
	GridPane grid = new GridPane();
	
	// private static String number="7";
	
	AddedWindow(Stage ps, String numcopy){
		
		primary = ps;
		
	        setTitle("Confirmation page");
	        grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));
	        
	        
	        
	        Text text = new Text();
	        text.setText(Integer.parseInt(numcopy)+" copies are added to database.");
	        text.setFill(Color.BROWN);
	        
	       //System.out.println(FoundWindow.copyNumber + " copies are added to database.");
	      //  System.out.println(number + " copies are added to database.");
	        
	        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
	        grid.add(text, 0, 0, 2, 1);
	        
	        
	        Scene scene = new Scene(grid, 300, 150);
	        setScene(scene);
	        
	 //      System.out.println(AddcopyController.copyNumber);
	}
	
/*	public static void setNumber(String s){
		number = s;
	}*/
}
