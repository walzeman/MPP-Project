package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import controller.AddcopyController;
import dataaccess.DataAccessFacade;

public class FoundWindow extends Stage {
	Stage primary;
   // public static String copyNumber="";
	
	GridPane grid = new GridPane();
	DataAccessFacade da = new DataAccessFacade();

	public FoundWindow(Stage ps, String isbn){
		
		   primary = ps;
		   
		    
		    
		   
	        setTitle("BOOK IS FOUND");
	        grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));
	        
	        Text text = new Text();
	        if(da.searchBook(isbn) != null)
	          text.setText("Book titled by "+da.searchBook(isbn).getTitle()+" is found.");
	        text.setFill(Color.BLUE);
	        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
	        grid.add(text, 0, 0, 2, 1);
	        
	        Text text1 = new Text();
	        text1.setText("How many copies do you want to add?");
	        grid.add(text1, 0, 2, 2, 1);
	        
	        Label numCopy = new Label(" No of copies :");
	        grid.add(numCopy, 0, 4);
	        TextField copyNumTextField = new TextField();
	        grid.add(copyNumTextField, 1, 4);
	        
	        
	        Button btn = new Button("  Add  ");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent e){
	        			
	        		    Stage addedPage = new AddedWindow(ps,copyNumTextField.getText());
	        			AddcopyController.addCopy(da.searchBook(isbn), Integer.parseInt(copyNumTextField.getText()));
	        		 
	        			addedPage.show();  
	        			hide();
	        			
	        	}
	        });
		     
	        HBox hbBtn = new HBox(20);
	        hbBtn.setAlignment(Pos.CENTER_RIGHT);
	        hbBtn.getChildren().addAll(btn);
	        grid.add(hbBtn, 1, 6);
	        
	        Scene scene = new Scene(grid, 400, 250);
	        setScene(scene);
		
	}
}

