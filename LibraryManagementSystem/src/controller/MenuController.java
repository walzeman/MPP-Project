package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.AddMember;
import view.CheckoutBook;
import view.UI;

public class MenuController {

	@FXML
	protected void handlecheckoutButton(ActionEvent event) throws IOException {
		CheckoutBook coBook = new CheckoutBook();
		coBook.show();
		
	}	
	
	@FXML
	protected void handleaddBookCopyButton(ActionEvent event) {
		UI ui = new UI();
		ui.show();

	}	
	
	@FXML
	protected void handleaddMemberButton(ActionEvent event) {
			AddMember addMember = new AddMember();
			addMember.show();
	}	
	
	@FXML
	protected void handlelistMemberButton(ActionEvent event) {
//		MainMenu mainMenu = new MainMenu(loggedinUser);
//		mainMenu.show();
		
	}	
	
	@FXML
	protected void handlelistBookButton(ActionEvent event) {
//		MainMenu mainMenu = new MainMenu(loggedinUser);
//		mainMenu.show();
		
	}	
}
