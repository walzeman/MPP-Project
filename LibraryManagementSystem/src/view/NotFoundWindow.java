package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NotFoundWindow extends Stage{

	
	Stage primary;
	GridPane grid = new GridPane();
	
	NotFoundWindow(Stage ps){
		
		primary = ps;
		
        setTitle("Not found page");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        
        
        Text text = new Text();
        text.setText("The requested book is not available.");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(text, 0, 0, 2, 1);
        
        Button btn = new Button();
        btn.setText("Try Again !");
     //   text1.setFill(Color.BLUE);
        btn.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e){
        
        		  ps.show(); 	
        		  hide();
        	}
        });
        
        HBox hbBtn = new HBox(20);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().addAll(btn);
        grid.add(hbBtn, 0,2,2,1);
        
        
        Scene scene = new Scene(grid, 300, 150);
        setScene(scene);
	}
}
