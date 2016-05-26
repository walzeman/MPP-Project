package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
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
import controller.MemberController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class AddMember extends Stage {

	private DataAccess da = new DataAccessFacade();
	private Integer idn = new Integer(501);
	GridPane grid;
	TextField idTextField;
	TextField firstNameTextField;
	TextField lastnameTextField;
	TextField phoneTextField;
	TextField streetTextField;
	TextField cityTextField;
	TextField stateTextField;
	TextField zipTextField;

	Stage secondWindow;
	Stage primaryStage;

	private void createSecondWindow() {
		secondWindow = new Member_Dialog(primaryStage);
		// messageBar.setText("");
	}

	public AddMember() {

		setTitle("LIBRARIAN PAGE");

		createSecondWindow();

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text text = new Text("Membership Details");
		text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(text, 0, 0, 2, 1);

		Label memberId = new Label("ID Number:");
		grid.add(memberId, 0, 1);
		idTextField = new TextField();
		idTextField.setDisable(true);

		idn += (Integer) da.readLibraryMember().size() - 1;

		idTextField.setText(idn.toString());
		grid.add(idTextField, 1, 1);

		Label firstName = new Label("First Name:");
		grid.add(firstName, 0, 2);
		firstNameTextField = new TextField();
		grid.add(firstNameTextField, 1, 2);
		GridPane.setHalignment(firstName, HPos.RIGHT);

		Label lastName = new Label("Last Name:");
		grid.add(lastName, 0, 3);
		lastnameTextField = new TextField();
		grid.add(lastnameTextField, 1, 3);
		GridPane.setHalignment(lastName, HPos.RIGHT);

		Label phoneName = new Label("Phone:");
		grid.add(phoneName, 0, 4);
		phoneTextField = new TextField();
		grid.add(phoneTextField, 1, 4);
		GridPane.setHalignment(phoneName, HPos.RIGHT);

		Label streetName = new Label("Street :");
		grid.add(streetName, 0, 5);
		streetTextField = new TextField();
		grid.add(streetTextField, 1, 5);
		GridPane.setHalignment(streetName, HPos.RIGHT);

		Label cityName = new Label("City :");
		grid.add(cityName, 0, 6);
		cityTextField = new TextField();
		grid.add(cityTextField, 1, 6);
		GridPane.setHalignment(cityName, HPos.RIGHT);

		Label stateName = new Label("State:");
		grid.add(stateName, 0, 7);
		stateTextField = new TextField();
		grid.add(stateTextField, 1, 7);
		GridPane.setHalignment(stateName, HPos.RIGHT);

		Label zip = new Label("Zip :");
		grid.add(zip, 0, 8);
		zipTextField = new TextField();
		grid.add(zipTextField, 1, 8);
		GridPane.setHalignment(zip, HPos.RIGHT);

		Button addbtn = new Button("Add");
		Button clearbtn = new Button("Clear");
		HBox hbBtn = new HBox(40);
		hbBtn.setAlignment(Pos.CENTER);
		hbBtn.getChildren().addAll(addbtn, clearbtn);
		grid.add(hbBtn, 1, 11);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 14);

		addbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				MemberController.addMember(firstNameTextField.getText(),
						lastnameTextField.getText(), phoneTextField.getText(),
						idTextField.getText(), streetTextField.getText(),
						cityTextField.getText(), stateTextField.getText(),
						zipTextField.getText());
				idTextField.clear();
				clearData();

				++idn;

				idTextField.setText(idn.toString());

				secondWindow.show();

			}
		});

		clearbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				clearData();

			}
		});

		Scene scene = new Scene(grid);
		setScene(scene);
		show();

	}

	public void clearData() {
		firstNameTextField.clear();
		lastnameTextField.clear();
		phoneTextField.clear();
		streetTextField.clear();
		cityTextField.clear();
		stateTextField.clear();
		zipTextField.clear();
	}

	public void createFirstMember() {

	}
}
