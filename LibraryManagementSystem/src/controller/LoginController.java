package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import view.MainMenu;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class LoginController {

	DataAccess da = new DataAccessFacade();
	@FXML
	private TextField userTextField;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Button submitButton;
	@FXML
	private Text errorText;

	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
		HashMap<String, User> userMap = da.getUserMap();
		if (! (userTextField.getText().equals("") || passwordTextField.getText().equals(""))) {
			User loggedinUser = userMap.get(userTextField.getText());
			if (loggedinUser != null) {
				if (loggedinUser.getPassword().equals(
						passwordTextField.getText())) {
					Stage stage = (Stage) submitButton.getScene().getWindow();
					stage.close();
					MainMenu mainMenu = new MainMenu(loggedinUser);
					mainMenu.show();

				} else {
					errorText.setText("Incorrect password");
				}
			} else {
				errorText.setText("User not Found");
			}
		}
		 else {
				errorText.setText("Provide username/password");
			}
		
	}
	
	public List<User> readLibraryMember(){
		HashMap<String, User> userMap = da.getUserMap();
		List<User> list = new ArrayList<User>(userMap.values());
		return list;
	}
}
