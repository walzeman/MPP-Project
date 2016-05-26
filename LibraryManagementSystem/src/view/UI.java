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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import dataaccess.DataAccessFacade;

public class UI extends Stage {

	GridPane grid;

	Stage foundWindow;
	Stage primaryStage;
	Stage notFoundWindow;
	String str;

	DataAccessFacade da = new DataAccessFacade();

	private void createNewWindow() {
		foundWindow = new FoundWindow(primaryStage, str);
		notFoundWindow = new NotFoundWindow(primaryStage);
	}

	public UI() {

		setTitle("ADMINISTRATOR PAGE");

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text text = new Text("ADD COPIES OF A BOOK");
		// text.getFill();
		text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(text, 0, 0, 2, 1);

		Text text1 = new Text(
				"First check whether the book is available or not.");
		grid.add(text1, 0, 2, 2, 1);

		Label memberId = new Label(" ISBN :");
		grid.add(memberId, 0, 4);
		TextField idTextField = new TextField();
		grid.add(idTextField, 1, 4);

		Button btn = new Button("  Check  ");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				str = idTextField.getText();
				createNewWindow();
				// System.out.println(da.searchBook(idTextField.getText()).getIsbn());
				if (da.searchBook(idTextField.getText()) != null) {
					foundWindow.show();
				} else
					notFoundWindow.show();
				close();

			}
		});

		HBox hbBtn = new HBox(20);
		hbBtn.setAlignment(Pos.CENTER_RIGHT);
		hbBtn.getChildren().addAll(btn);
		grid.add(hbBtn, 1, 6);

		Scene scene = new Scene(grid, 400, 250);
		setScene(scene);
		show();
	}

}
